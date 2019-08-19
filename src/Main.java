import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		CSVReader reader = new CSVReader();
		ArrayList<QuestionRecord> records = null;
		try {
			records = reader.read("/home/vishnu/Downloads/rajyaSabhaData.csv", true);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
		}
		
		// System.out.println(records.size());
		
		DataFilters filters = new DataFilters();
		
		ArrayList<QuestionRecord> uniqueRecords = filters.unique(records);
		// System.out.println(uniqueRecords.size());
		
		LinkedHashMap<String, ArrayList<QuestionRecord>> dataByMinistry = filters.groupByMinistry(uniqueRecords);
		// System.out.println(dataByMinistry.size());
		
		for(Map.Entry<String, ArrayList<QuestionRecord>> ministry : dataByMinistry.entrySet()) {
			System.out.println(ministry.getKey() + " : " + ministry.getValue().size());
		}
	}
}
