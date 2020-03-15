package huffmancode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCodeDemo {

	public static void main(String[] args) {

//		String src = "D:/src.txt";
//		String dst = "D:/dst.zip";
//		zipFile(src, dst);

		String src = "D:/dst.zip";
		String dst = "D:/src2.txt";
		unZipFile(src, dst);
		
//		String string = "i like like like java do you like a java";
//		// 1.转换成2进制数组
//		byte[] bytes = string.getBytes();
//		// 2.获取每个字符节点出现的次数（字符：node.data 次数：node.weight)
//		List<Node> nodes = getNodes(bytes);
//		// 3.创建哈夫曼树
//		Node huffmanTreeRoot = createHuffmanTree(nodes);
//		// 4.生成哈夫曼编码
//		Map<Byte, String> map = getCodes(huffmanTreeRoot);
//		// 5.压缩数据
//		byte[] zip = zip(bytes, map);
//		
////		byte[] zip = huffmanInCode(bytes);
////		System.out.println(Arrays.toString(zip));
//
//		
//		byte[] huffmanDecode = huffmanDecode(map, zip); 
//		System.out.println(new String(huffmanDecode));
//		 

	}

	public static void unZipFile(String zipFile, String dstFile) {

		InputStream is = null;
		ObjectInputStream ois = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(zipFile);
			ois = new ObjectInputStream(is);
			byte[] huffmanBytes = (byte[]) ois.readObject();

			@SuppressWarnings("unchecked")
			Map<Byte, String> huffmansCodes = (Map<Byte, String>) ois.readObject();
			byte[] bytes = huffmanDecode(huffmansCodes, huffmanBytes);
			os = new FileOutputStream(dstFile);
			os.write(bytes);
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();
				ois.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void zipFile(String srcFile, String dstFile) {

		FileInputStream is = null;
		OutputStream os = null;
		ObjectOutputStream oos = null;
		try {
			is = new FileInputStream(srcFile);
			byte[] b = new byte[is.available()];
			is.read(b);
			// 获取编码后的文件字节数组
			byte[] huffmanBytes = huffmanInCode(b);
			os = new FileOutputStream(dstFile);
			oos = new ObjectOutputStream(os);
			oos.writeObject(huffmanBytes);
			oos.writeObject(huffmanCodes);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				is.close();
				oos.close();
				os.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static byte[] huffmanDecode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {

		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = 0; i < huffmanBytes.length; i++) {
			boolean flag = (i == huffmanBytes.length - 1);
			stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
		}
		System.out.println(stringBuilder);
		Map<String, Byte> map = new HashMap<String, Byte>();
		for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		System.out.println(map.toString());
		List<Byte> list = new ArrayList<>();
		for (int i = 0; i < stringBuilder.length();) {
			int count = 1;
			boolean flag = true;
			Byte b = null;

			while (flag) {
				String key = stringBuilder.substring(i, i + count);
				b = map.get(key);

				if (b == null) {
					count++;
				} else {
					flag = false;
				}
			}

			list.add(b);
			i += count;
		}

		byte[] b = new byte[list.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;

	}

	private static String byteToBitString(boolean flag, byte b) {

		int temp = b;
		if (flag) {
			temp |= 256;
		}
		String str = Integer.toBinaryString(temp);
		if (flag) {
			return str.substring(str.length() - 8);
		} else {
			return str;
		}

	}

	public static byte[] huffmanInCode(byte[] bytes) {

		// 2.获取每个字符节点出现的次数（字符：node.data 次数：node.weight)
		List<Node> nodes = getNodes(bytes);
		// 3.创建哈夫曼树
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		// 4.生成哈夫曼编码
		Map<Byte, String> map = getCodes(huffmanTreeRoot);
		// 5.压缩数据
		byte[] zip = zip(bytes, map);

		return zip;

	}

	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCods) {

		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : bytes) {
			stringBuilder.append(huffmanCods.get(b));
		}

		int len;
		if (stringBuilder.length() % 8 == 0) {
			len = stringBuilder.length() / 8;
		} else {
			len = stringBuilder.length() / 8 + 1;
		}

		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;

		for (int i = 0; i < stringBuilder.length(); i += 8) {
			String strByte;
			if (i + 8 > stringBuilder.length()) {
				strByte = stringBuilder.substring(i);
			} else {
				strByte = stringBuilder.substring(i, i + 8);
			}
			huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
			index++;
		}

		return huffmanCodeBytes;

	}

	// 将哈夫曼编码表存放在Map<Byte, String>
	static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
	// 用于拼接生成的哈夫曼编码
	static StringBuilder stringBuilder = new StringBuilder();

	private static Map<Byte, String> getCodes(Node root) {
		if (root == null) {
			return null;
		}
		getCodes(root.left, "0", stringBuilder);
		getCodes(root.right, "1", stringBuilder);
		return huffmanCodes;
	}

	private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
		StringBuilder builder = new StringBuilder(stringBuilder);

		builder.append(code);
		if (node != null) {

			if (node.data == null) {
				getCodes(node.left, "0", builder);
				getCodes(node.right, "1", builder);
			} else {
				huffmanCodes.put(node.data, builder.toString());
			}
		}
	}

	private static List<Node> getNodes(byte[] bytes) {

		List<Node> list = new ArrayList<Node>();

		// 遍历bytes， 统计每一个byte出现的次数
		HashMap<Byte, Integer> counts = new HashMap<>();
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			} else {
				counts.put(b, count + 1);
			}
		}

		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			list.add(new Node(entry.getKey(), entry.getValue()));
		}

		return list;
	}

	private static Node createHuffmanTree(List<Node> nodes) {

		while (nodes.size() > 1) {

			Collections.sort(nodes);
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);

			Node parentNode = new Node(null, leftNode.weight + rightNode.weight);
			parentNode.left = leftNode;
			parentNode.right = rightNode;

			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parentNode);

		}

		return nodes.get(0);

	}

}
