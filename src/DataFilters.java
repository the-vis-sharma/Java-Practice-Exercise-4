import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class DataFilters {
	
	public ArrayList<QuestionRecord> unique(ArrayList<QuestionRecord> data) {
		return (ArrayList<QuestionRecord>) data.stream().distinct().collect(Collectors.toList());	
	}
	
	public LinkedHashMap<String, ArrayList<QuestionRecord>> groupByMinistry(ArrayList<QuestionRecord> data) {
		LinkedHashMap<String, ArrayList<QuestionRecord>> map = new LinkedHashMap<String, ArrayList<QuestionRecord>>();
		
		for(QuestionRecord record : data) {
			if(map.containsKey(record.getMinistry())) {
				map.get(record.getMinistry()).add(record);
			}
			else {
				ArrayList<QuestionRecord> list = new ArrayList<QuestionRecord>();
				map.put(record.getMinistry(), list);
			}
		}
		
		return map;
	}
	
}
