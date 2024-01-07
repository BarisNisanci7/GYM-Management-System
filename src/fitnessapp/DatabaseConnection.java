/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitnessapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
/**
 *
 * @author Baris
 */
public class DatabaseConnection {
    
    public static final String DB_URL = "jdbc:mysql://localhost:3306/FitnessAppDatabase";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "12345678";
    
    public Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;     
    private Statement statement;
    public void DataBaseConnection()     {
        String url = "jdbc:mysql://localhost:3306/FitnessAppDatabase";
        try {             
            Class.forName("com.mysql.cj.jdbc.Driver");         
        } catch (ClassNotFoundException ex) {             
            System.out.println("Could not find driver ..");         
        }          
        try {
            connection = DriverManager.getConnection(url, DatabaseConnection.DB_USERNAME, DatabaseConnection.DB_PASSWORD);
            //System.out.println("Connection successful...");         
        } catch (SQLException ex) {
            System.out.println("Connection failure...");         
        }     
    }

    
    public String getUserName() {
        String query = "SELECT userName FROM User";

        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("userName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public String getUserPassword() {
        String query = "SELECT userPassword FROM User LIMIT 1";  // Assuming your table name is 'User'

        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("userPassword");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no user is found
    }

    
    public void changePasswordByUserName(String userName, String newPassword) {
        String query = "UPDATE User SET userPassword = ? WHERE userName = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, userName);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Password changed successfully for user: " + userName);
            } else {
                System.out.println("User not found or password not changed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        String query = "SELECT trainerID, trainerName, trainerSurname, trainerGender, trainerExpertise FROM Trainer";
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int trainerID = resultSet.getInt("trainerID");
                String trainerName = resultSet.getString("trainerName");
                String trainerSurname = resultSet.getString("trainerSurname");
                String trainerGender = resultSet.getString("trainerGender");
                String trainerExpertise = resultSet.getString("trainerExpertise");

                Trainer trainer = new Trainer(trainerID, trainerName, trainerSurname, trainerGender, trainerExpertise);
                trainers.add(trainer);
            }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return trainers;
        }
        
        
        
        public void deleteExerciseByName(String exerciseName) {
        String query = "DELETE FROM Exercise WHERE exerciseName = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, exerciseName);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Exercise deleted successfully: " + exerciseName);
            } else {
                System.out.println("Exercise not found: " + exerciseName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new trainer
    public void addTrainer(Trainer trainer) {
        String query = "INSERT INTO Trainer (trainerName, trainerSurname, trainerGender, trainerExpertise) VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, trainer.getTrainerName());
            preparedStatement.setString(2, trainer.getTrainerSurname());
            preparedStatement.setString(3, trainer.getTrainerGender());
            preparedStatement.setString(4, trainer.getTrainerExpertise());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an existing trainer
    public void updateTrainer(Trainer trainer) {
        String query = "UPDATE Trainer SET trainerName = ?, trainerSurname = ?, trainerGender = ?, trainerExpertise = ? WHERE trainerID = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, trainer.getTrainerName());
            preparedStatement.setString(2, trainer.getTrainerSurname());
            preparedStatement.setString(3, trainer.getTrainerGender());
            preparedStatement.setString(4, trainer.getTrainerExpertise());
            preparedStatement.setInt(5, trainer.getTrainerID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a trainer
 public void deleteTrainerByName(String trainerName) {
    String query = "DELETE FROM Trainer WHERE trainerName=?";
    try {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, trainerName);
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // Method to get a trainer by ID
    public Trainer getTrainerByID(int trainerID) {
        Trainer trainer = null;
        String query = "SELECT * FROM Trainer WHERE trainerID = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, trainerID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String trainerName = resultSet.getString("trainerName");
                String trainerSurname = resultSet.getString("trainerSurname");
                String trainerGender = resultSet.getString("trainerGender");
                String trainerExpertise = resultSet.getString("trainerExpertise");
                trainer = new Trainer(trainerID, trainerName, trainerSurname, trainerGender, trainerExpertise);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainer;
    }
    
    
    public String getTrainerNameByTrainerID(int trainerID) {
    String query = "SELECT trainerName FROM Trainer WHERE trainerID=?";
    String trainerName = null;

    try {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, trainerID);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            trainerName = resultSet.getString("trainerName");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return trainerName;
}


    // Method to get trainers by expertise
    public List<Trainer> getTrainersByExpertise(String expertise) {
        List<Trainer> trainers = new ArrayList<>();
        String query = "SELECT * FROM Trainer WHERE trainerExpertise = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, expertise);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int trainerID = resultSet.getInt("trainerID");
                String trainerName = resultSet.getString("trainerName");
                String trainerSurname = resultSet.getString("trainerSurname");
                String trainerGender = resultSet.getString("trainerGender");
                String trainerExpertise = resultSet.getString("trainerExpertise");
                Trainer trainer = new Trainer(trainerID, trainerName, trainerSurname, trainerGender, trainerExpertise);
                trainers.add(trainer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainers;
    }

    public void addMeasurement(Measurement measurement) {
    String query = "INSERT INTO Measurement (date, weight, waistSize, chestSize, hipSize) VALUES (?, ?, ?, ?, ?)";

    try {
        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, measurement.getMeasurementDate());
        preparedStatement.setDouble(2, measurement.getWeight());
        preparedStatement.setDouble(3, measurement.getWaistSize());
        preparedStatement.setDouble(4, measurement.getChestSize());
        preparedStatement.setDouble(5, measurement.getHipSize());

        preparedStatement.executeUpdate();

        // Retrieve the generated measurementID
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int generatedMeasurementID = generatedKeys.getInt(1);

            // Optionally, you may associate the measurement with a student or update other tables as needed.
            // For example, if you have a studentID associated with the measurement:
            // setMeasurementForStudent(studentID, new Measurement(generatedMeasurementID, ...));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    // Method to get all trainers along with their gym names
// Method to get all students along with their trainer's details
// Method to get all students along with their trainer's and program's details
    public List<Student> getAllStudentsWithTrainerAndProgram() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT Student.studentID, Student.studentName, Student.studentSurname, Student.birthDate, Student.studentMembership, Student.studentGender, Student.trainerID, Student.programID, Trainer.trainerName, Trainer.trainerSurname, Trainer.trainerGender, Trainer.trainerExpertise, Program.programPrivateID, Program.programID, Program.programName, Program.programDuration FROM Student INNER JOIN Trainer ON Student.trainerID = Trainer.trainerID INNER JOIN Program ON Student.programID = Program.programID";
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int studentID = resultSet.getInt("studentID");
                String studentName = resultSet.getString("studentName");
                String studentSurname = resultSet.getString("studentSurname");
                String birthDate = resultSet.getString("birthDate");
                int studentMembership = resultSet.getInt("studentMembership");
                String gender = resultSet.getString("studentGender");
                int trainerID = resultSet.getInt("trainerID");
                int programID = resultSet.getInt("programID");
                String trainerName = resultSet.getString("trainerName");
                String trainerSurname = resultSet.getString("trainerSurname");
                String trainerGender = resultSet.getString("trainerGender");
                String trainerExpertise = resultSet.getString("trainerExpertise");
                int programPrivateID = resultSet.getInt("programPrivateID");
                String programName = resultSet.getString("programName");
                int programDuration = resultSet.getInt("programDuration");
                int exerciseID = resultSet.getInt("exerciseID");
                
                Trainer trainer = new Trainer(trainerID, trainerName, trainerSurname, trainerGender, trainerExpertise);
                Program program = new Program(programPrivateID, programID, programName, programDuration,  exerciseID );
                Student student = new Student(studentID, studentName, studentSurname, birthDate, studentMembership, gender, trainerID, programID);
                student.setTrainerID(trainerID); // assuming you have a setTrainer method in your Student class
                student.setProgram(program); // assuming you have a setProgram method in your Student class
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    
    public List<Student> getAllStudents() {
    List<Student> students = new ArrayList<>();
    String query = "SELECT studentID, studentName, studentSurname, birthDate, studentMembership, studentGender, trainerID, programID FROM Student";
    try {
        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int studentID = resultSet.getInt("studentID");
            String studentName = resultSet.getString("studentName");
            String studentSurname = resultSet.getString("studentSurname");
            String birthDate = resultSet.getString("birthDate");
            int studentMembership = resultSet.getInt("studentMembership");
            String studentGender = resultSet.getString("studentGender");
            int trainerID = resultSet.getInt("trainerID");
            int programID = resultSet.getInt("programID");

            Student student = new Student(studentID, studentName, studentSurname, birthDate, studentMembership, studentGender, trainerID, programID);
            students.add(student);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return students;
    }

    public void addStudent(Student student) {
    String query = "INSERT INTO Student (studentName, studentSurname, birthDate, studentMembership, studentGender, trainerID, programID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentSurname());
            preparedStatement.setString(3, student.getBirthDate());
            preparedStatement.setInt(4, student.getStudentMembership());
            preparedStatement.setString(5, student.getStudentGender());
            preparedStatement.setInt(6, student.getTrainerID());
            preparedStatement.setInt(7, student.getProgramID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateStudent(Student student) {
    String query = "UPDATE Student SET studentName=?, studentSurname=?, birthDate=?, studentMembership=?, studentGender=?, trainerID=?, programID=? WHERE studentID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentSurname());
            preparedStatement.setString(3, student.getBirthDate());
            preparedStatement.setInt(4, student.getStudentMembership());
            preparedStatement.setString(5, student.getStudentGender());
            preparedStatement.setInt(6, student.getTrainerID());
            preparedStatement.setInt(7, student.getProgramID());
            preparedStatement.setInt(8, student.getStudentID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteStudentByName(String studentName) {
        String query = "DELETE FROM Student WHERE studentName=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Student> getStudentsByProgramName(String programName) {
    List<Student> students = new ArrayList<>();
    String query = "SELECT Student.studentID, Student.studentName, Student.studentSurname, " +
                   "Student.birthDate, Student.studentMembership, Student.studentGender, " +
                   "Student.trainerID, Student.programID " +
                   "FROM Student " +
                   "INNER JOIN Program ON Student.programID = Program.programID " +
                   "WHERE Program.programName=?";
    
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, programName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int studentID = resultSet.getInt("studentID");
                String studentName = resultSet.getString("studentName");
                String studentSurname = resultSet.getString("studentSurname");
                String birthDate = resultSet.getString("birthDate");
                int studentMembership = resultSet.getInt("studentMembership");
                String gender = resultSet.getString("studentGender");
                int trainerID = resultSet.getInt("trainerID");
                int programID = resultSet.getInt("programID");

                Student student = new Student(studentID, studentName, studentSurname, birthDate, studentMembership, gender, trainerID, programID);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public List<Student> getStudentsByTrainer(int trainerID) {
    List<Student> students = new ArrayList<>();
    String query = "SELECT * FROM Student WHERE trainerID=?";
    
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, trainerID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int studentID = resultSet.getInt("studentID");
                String studentName = resultSet.getString("studentName");
                String studentSurname = resultSet.getString("studentSurname");
                String birthDate = resultSet.getString("birthDate");
                int studentMembership = resultSet.getInt("studentMembership");
                String gender = resultSet.getString("studentGender");
                int programID = resultSet.getInt("programID");

                Student student = new Student(studentID, studentName, studentSurname, birthDate, studentMembership, gender, trainerID, programID);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public List<Student> getStudentsByTrainerName(String trainerName) {
    List<Student> students = new ArrayList<>();
    String query = "SELECT Student.* FROM Student " +
                   "INNER JOIN Trainer ON Student.trainerID = Trainer.trainerID " +
                   "WHERE Trainer.trainerName=?";

    try {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, trainerName);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int studentID = resultSet.getInt("studentID");
            String studentName = resultSet.getString("studentName");
            String studentSurname = resultSet.getString("studentSurname");
            String birthDate = resultSet.getString("birthDate");
            int studentMembership = resultSet.getInt("studentMembership");
            String studentGender = resultSet.getString("studentGender");
            int trainerID = resultSet.getInt("trainerID");
            int programID = resultSet.getInt("programID");

            Student student = new Student(studentID, studentName, studentSurname, birthDate, studentMembership, studentGender, trainerID, programID);
            students.add(student);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return students;
}

    
    public List<Student> getStudentsWithTrainerNames() {
    List<Student> students = new ArrayList<>();
    String query = "SELECT Student.*, Trainer.trainerName, Trainer.trainerSurname " +
                   "FROM Student " +
                   "LEFT JOIN Trainer ON Student.trainerID = Trainer.trainerID";

    try {
        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int studentID = resultSet.getInt("studentID");
            String studentName = resultSet.getString("studentName");
            String studentSurname = resultSet.getString("studentSurname");
            String birthDate = resultSet.getString("birthDate");
            int studentMembership = resultSet.getInt("studentMembership");
            String gender = resultSet.getString("studentGender");
            int trainerID = resultSet.getInt("trainerID");
            int programID = resultSet.getInt("programID");

            String trainerName = resultSet.getString("trainerName");
            String trainerSurname = resultSet.getString("trainerSurname");

            Trainer trainer = new Trainer(trainerID, trainerName, trainerSurname, null, null);
            Program program = new Program(0, programID, null, 0, 0);

            Student student = new Student(studentID, studentName, studentSurname, birthDate, studentMembership, gender, trainerID, programID);
            student.setTrainerID(trainerID);
            student.setProgram(program);
            students.add(student);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return students;
}


    public int getStudentIdByStudentName(String studentName) {
    int studentID = -1; // Default value if not found
    String query = "SELECT studentID FROM Student WHERE studentName=?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                studentID = resultSet.getInt("studentID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentID;
    }

    public int getTrainerIDByTrainerName(String trainerName) {
    int trainerID = -1; // Default value if not found
    String query = "SELECT trainerID FROM Trainer WHERE trainerName=?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, trainerName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                trainerID = resultSet.getInt("trainerID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trainerID;
    }

    
    public void addExercise(Exercise exercise) {
        String query = "INSERT INTO Exercise (exerciseName, exerciseType, sets, reps) VALUES (?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, exercise.getExerciseName());
            preparedStatement.setString(2, exercise.getExerciseType());
            preparedStatement.setInt(3, exercise.getSets());
            preparedStatement.setInt(4, exercise.getReps());

            preparedStatement.executeUpdate();
            System.out.println("Exercise added successfully: " + exercise.getExerciseName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public void setMeasurementForStudent(int studentID, Measurement measurement) {
    String query = "UPDATE Student SET measurementID=? WHERE studentID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, measurement.getMeasurementID());
            preparedStatement.setInt(2, studentID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setTrainerForStudent(int studentID, int trainerID) {
    String query = "UPDATE Student SET trainerID=? WHERE studentID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, trainerID);
            preparedStatement.setInt(2, studentID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void setProgramForStudent(int studentID, int programID) {
    String query = "UPDATE Student SET programID=? WHERE studentID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, programID);
            preparedStatement.setInt(2, studentID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Student> getStudentsMeasurements() {
    List<Student> students = new ArrayList<>();
    String query = "SELECT Student.*, Measurement.* FROM Student " +
                   "LEFT JOIN Measurement ON Student.measurementID = Measurement.measurementID";
    
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int studentID = resultSet.getInt("studentID");
                String studentName = resultSet.getString("studentName");
                String studentSurname = resultSet.getString("studentSurname");
                String birthDate = resultSet.getString("birthDate");
                int studentMembership = resultSet.getInt("studentMembership");
                String studentGender = resultSet.getString("studentGender");
                int trainerID = resultSet.getInt("trainerID");
                int programID = resultSet.getInt("programID");

                int measurementID = resultSet.getInt("measurementID");
                String measurementDate = resultSet.getString("date");
                double weight = resultSet.getDouble("weight");
                double waistSize = resultSet.getDouble("waistSize");
                double chestSize = resultSet.getDouble("chestSize");
                double hipSize = resultSet.getDouble("hipSize");

                Measurement measurement = new Measurement(measurementID, measurementDate, weight, waistSize, chestSize, hipSize);
                Student student = new Student(studentID, studentName, studentSurname, birthDate, studentMembership, studentGender, trainerID, programID);
                student.setMeasurementID(measurementID);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
   public List<Measurement> getMeasurementByStudentName(String studentName) {
    List<Measurement> measurements = new ArrayList<>();
    String query = "SELECT Measurement.* FROM Measurement " +
                   "INNER JOIN Student ON Measurement.measurementID = Student.measurementID " +
                   "WHERE Student.studentName = ?";

    try {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, studentName);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int measurementID = resultSet.getInt("measurementID");
            String date = resultSet.getString("date");
            double weight = resultSet.getDouble("weight");
            double waistSize = resultSet.getDouble("waistSize");
            double chestSize = resultSet.getDouble("chestSize");
            double hipSize = resultSet.getDouble("hipSize");

            Measurement measurement = new Measurement(measurementID, date, weight, waistSize, chestSize, hipSize);
            measurements.add(measurement);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return measurements;
}


    
    public List<Program> getAllPrograms() {
    List<Program> programs = new ArrayList<>();
    String query = "SELECT * FROM Program";
    
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int programPrivateID = resultSet.getInt("programPrivateID");
                int programID = resultSet.getInt("programID");
                String programName = resultSet.getString("programName");
                int programDuration = resultSet.getInt("programDuration");
                int exerciseID = resultSet.getInt("exerciseID");

                Program program = new Program(programPrivateID, programID, programName, programDuration, exerciseID);
                programs.add(program);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programs;
    }

    
    public String getProgramNameByProgramID(int programID) {
    String programName = null; // Default value if not found
    String query = "SELECT programName FROM Program WHERE programID=?";

    try {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, programID);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            programName = resultSet.getString("programName");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return programName;
}

    
    public int getProgramIDByProgramName(String programName) {
    int programID = -1; // Default value if not found
    String query = "SELECT programID FROM Program WHERE programName=?";

    try {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, programName);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            programID = resultSet.getInt("programID");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return programID;
}


    public List<Program> getProgramsByExerciseName(String exerciseName) {
    List<Program> programs = new ArrayList<>();
    String query = "SELECT Program.* FROM Program " +
                   "INNER JOIN Exercise ON Program.exerciseID = Exercise.exerciseID " +
                   "WHERE Exercise.exerciseName=?";
    
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, exerciseName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int programPrivateID = resultSet.getInt("programPrivateID");
                int programID = resultSet.getInt("programID");
                String programName = resultSet.getString("programName");
                int programDuration = resultSet.getInt("programDuration");
                int exerciseID = resultSet.getInt("exerciseID");

                Program program = new Program(programPrivateID, programID, programName, programDuration, exerciseID);
                programs.add(program);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programs;
    }

    
    public List<Exercise> getAllExercises() {
    List<Exercise> exercises = new ArrayList<>();
    String query = "SELECT * FROM Exercise";
    
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int exerciseID = resultSet.getInt("exerciseID");
                String exerciseName = resultSet.getString("exerciseName");
                String exerciseType = resultSet.getString("exerciseType");
                int sets = resultSet.getInt("sets");
                int reps = resultSet.getInt("reps");

                Exercise exercise = new Exercise(exerciseID, exerciseName, exerciseType, sets, reps);
                exercises.add(exercise);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercises;
    }

    public Exercise getExerciseByName(String exerciseName) {
    String query = "SELECT * FROM Exercise WHERE exerciseName=?";
    Exercise exercise = null;

    try {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, exerciseName);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int exerciseID = resultSet.getInt("exerciseID");
            String type = resultSet.getString("exerciseType");
            int sets = resultSet.getInt("sets");
            int reps = resultSet.getInt("reps");

            exercise = new Exercise(exerciseID, exerciseName, type, sets, reps);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return exercise;
}

    public List<Program> getProgramsWithExerciseNames() {
    List<Program> programs = new ArrayList<>();
    String query = "SELECT Program.*, Exercise.exerciseName " +
                   "FROM Program " +
                   "LEFT JOIN Exercise ON Program.exerciseID = Exercise.exerciseID";

    try {
        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int programPrivateID = resultSet.getInt("programPrivateID");
            int programID = resultSet.getInt("programID");
            String programName = resultSet.getString("programName");
            int programDuration = resultSet.getInt("programDuration");
            int exerciseID = resultSet.getInt("exerciseID");
            String exerciseName = resultSet.getString("exerciseName");

            Exercise exercise = new Exercise(exerciseID, exerciseName, null, 0, 0);
            Program program = new Program(programPrivateID, programID, programName, programDuration, exerciseID);
            programs.add(program);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return programs;
}
    
    
    public String getExerciseNameByExerciseID(int exerciseID) {
    String query = "SELECT exerciseName FROM Exercise WHERE exerciseID=?";
    String exerciseName = null;

    try {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, exerciseID);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            exerciseName = resultSet.getString("exerciseName");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return exerciseName;
}

  
    
    public List<Admin> getAllAdmins() {
    List<Admin> admins = new ArrayList<>();
    String query = "SELECT * FROM Admin";
    
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int adminID = resultSet.getInt("adminID");
                String adminName = resultSet.getString("adminName");
                String adminSurname = resultSet.getString("adminSurname");
                String adminPassword = resultSet.getString("adminPassword");
                String adminEmail = resultSet.getString("adminEmail");

                Admin admin = new Admin(adminID, adminName, adminSurname, adminPassword, adminEmail);
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }


}
