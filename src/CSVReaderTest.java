import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CSVReaderTest {

	CSVReader reader = null;
	
	@BeforeEach
	void init() {
		reader = new CSVReader();
	}
	
	@Test
	void testAllDataLoaded() throws FileNotFoundException, IOException {
		ArrayList<QuestionRecord> list = reader.read("/home/vishnu/Downloads/rajyaSabhaData.csv", true);
		int actualSize = list.size();
		int expectedSize = 32171;
		assertEquals(expectedSize, actualSize);
	}
	
	@Test
	void testFileHandlingException() {
		assertThrows(FileNotFoundException.class, () -> reader.read("/home/vishnu/Downloads/rajyaSabhaData1.csv", true));
	}

}
