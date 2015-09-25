package BUU.Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.TextExtractingVisitor;

public class ParserTest {

	public static void main(String[] args) throws IOException {
		String filePath = "G:\\tianya\\"
				+ "0bb8456d-a940-4e76-abc4-214219fa62ce";
		File htmlFile = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(htmlFile));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		try {
			Parser parser = new Parser(sb.toString());

			// if(parser.elements().hasMoreNodes()){

			Node node = null;
			String split = "";
			while (parser.elements().hasMoreNodes()) {
				node = parser.elements().nextNode();
				listTree(node, split);
			}

		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void listTree(Node node, String split) {
		String[] tags=node.getText().split(" ");
	if(tags.length>0)
		System.out.println(split +node.getText());
		split += "\t";
		Node son = null;
		if (node.getChildren() != null) {
			NodeList nodes = node.getChildren();
			for (int i = 0; i < nodes.size(); i++) {
				son = nodes.elementAt(i);
				listTree(son, split);
			}
		}

	}

}
