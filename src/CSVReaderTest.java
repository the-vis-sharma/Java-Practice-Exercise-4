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
	
	@Test 
	void testInvalidCSV() {
		String actualHeader = "id,answer_date,ministry,question_type,question_no,question_description,answer";
		// String expectedHeader = "id,answer_date,ministry,question_type,question_no,question_by,question_title,question_description,answer";
		assertFalse(reader.validateCSV(actualHeader), "Validating CSV File");
	}

}
