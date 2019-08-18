import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CSVReader {
	public ArrayList<QuestionRecord> read(String path, boolean hasHeader) throws FileNotFoundException, IOException {
		ArrayList<QuestionRecord> records = new ArrayList<QuestionRecord>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
				
		FileReader fileReader = null;
		BufferedReader bufferReader = null;
		try {
			fileReader = new FileReader(path);
			bufferReader = new BufferedReader(fileReader);
			String row = new String();
			boolean isHeaderSkipped = false;
			while((row = bufferReader.readLine()) != null) {
				if(hasHeader && !isHeaderSkipped) {
					isHeaderSkipped = true;
					continue;
				}
				// System.out.println(row);
				String[] cols = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				QuestionRecord record = new QuestionRecord(Integer.parseInt(cols[0]), 
						LocalDate.parse(cols[1], formatter), 
						cols[2], (cols[3].equals("STARRED")) ? true : false, 
						Integer.parseInt(cols[4]), cols[5], cols[6], cols[7]);
				records.add(record);
			}
		} 	
		finally {
			if(bufferReader != null) {
				try {
					bufferReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return records;
	}
}
