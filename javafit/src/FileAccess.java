import java.io.BufferedReader;
import java.io.FileReader;

// Write code to load the workouts from the provided workouts.csv file. The function should return a Workouts object.

public class FileAccess {
  
  public static Workouts loadWorkouts() {
    // What is a try/catch block and why do we need one?
    // What is an exception?
	  Workouts parsedWorkouts = new Workouts();
	  try (BufferedReader b = new BufferedReader(new FileReader("data/" + Config.WORKOUTFILE))) {
		  String readLine;
		  while((readLine = b.readLine()) != null) {
			  String[] parsed = readLine.split(",");
			  parsedWorkouts.addWorkout(parsed[0],Workouts.Equipment.valueOf(parsed[1]), Workouts.Muscle.valueOf(parsed[2]),
					  Workouts.Muscle.valueOf(parsed[3]), parsed[4], parsed[5]);
		  }
	  } catch(Exception e) {
		  e.printStackTrace();
	  }
	  return parsedWorkouts;
  }

}
