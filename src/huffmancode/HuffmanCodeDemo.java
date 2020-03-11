package huffmancode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCodeDemo {

	public static void main(String[] args) {
		String string = "i like like like java do you like a java";
		// 1.ת����2��������
		byte[] bytes = string.getBytes();
		// 2.��ȡÿ���ַ��ڵ���ֵĴ������ַ���node.data ������node.weight)
		List<Node> nodes = getNodes(bytes);
		// 3.������������
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		// 4.���ɹ���������
		Map<Byte, String> map = getCodes(huffmanTreeRoot);
		// 5.ѹ������
		byte[] zip = zip(bytes, map);

//		byte[] zip = huffmanInCode(content);
//		System.out.println(Arrays.toString(zip));

		byte[] huffmanDecode = huffmanDecode(map, zip);
		System.out.println(new String(huffmanDecode));

	}

	private static byte[] huffmanDecode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < huffmanBytes.length; i++) {
			boolean flag = (i == huffmanBytes.length - 1);
			stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
		}

		Map<String, Byte> map = new HashMap<String, Byte>();
		for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}

		List<Byte> list = new ArrayList<Byte>();
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

	public static byte[] huffmanInCode(String string) {
		// 1.ת����2��������
		byte[] bytes = string.getBytes();
		// 2.��ȡÿ���ַ��ڵ���ֵĴ������ַ���node.data ������node.weight)
		List<Node> nodes = getNodes(bytes);
		// 3.������������
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		// 4.���ɹ���������
		Map<Byte, String> map = getCodes(huffmanTreeRoot);
		// 5.ѹ������
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

	// �����������������Map<Byte, String>
	static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
	// ����ƴ�����ɵĹ���������
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

		// ����bytes�� ͳ��ÿһ��byte���ֵĴ���
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
