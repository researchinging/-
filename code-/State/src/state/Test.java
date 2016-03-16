package state;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Work emergencyProjects = new Work();
		 emergencyProjects.setCurrent(new ForenoonState());
         emergencyProjects.hour = 9;
         emergencyProjects.WriteProgram();
         emergencyProjects.hour = 10;
         emergencyProjects.WriteProgram();
         emergencyProjects.hour = 12;
         emergencyProjects.WriteProgram();
         emergencyProjects.hour = 13;
         emergencyProjects.WriteProgram();
         emergencyProjects.hour = 14;
         emergencyProjects.WriteProgram();
         emergencyProjects.hour = 17;

         //emergencyProjects.WorkFinished = true;
         emergencyProjects.finished = false;

         emergencyProjects.WriteProgram();
         emergencyProjects.hour = 19;
         emergencyProjects.WriteProgram();
         emergencyProjects.hour = 22;
         emergencyProjects.WriteProgram();
	}

}
