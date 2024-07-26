import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test04_CharacterStreamTest {
	public static void main(String[] args) {
		// 문자 스트림 : FileReader, FileWriter
		try (FileReader reader = new FileReader("data/big_input.txt");
				FileWriter writer = new FileWriter("data/big_input_2.txt")) {

			int c; // 문자 전달 바구니
			while ((c = reader.read()) != -1) {
				writer.write(c);
			}
			System.out.println("복사 끝!");

		} catch (IOException e) {

		}
	}
}
