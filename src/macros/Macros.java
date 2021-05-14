
package macros;
import javax.swing.JOptionPane;

public class Macros {


    public static void main(String[] args) {
        
        //Checking if the user entered a string
        String userName = JOptionPane.showInputDialog(null, "Name: ");
        while (userName.equals("") || numberOrNot(userName)) {
            JOptionPane.showMessageDialog(null, "You have not entered a name");
            userName = JOptionPane.showInputDialog(null, "Name: ");
        }

        //Checking if the user entered a number
        String stringUserWeight = JOptionPane.showInputDialog(null, "Enter your weight");
        int userWeight = 0;
        if (numberOrNot(stringUserWeight)) {
            userWeight = Integer.parseInt(stringUserWeight);            
        }
        else while (!numberOrNot(stringUserWeight)) {
            JOptionPane.showMessageDialog(null, "You have not entered a number");
            stringUserWeight = JOptionPane.showInputDialog(null, "Enter your weight");
            if (numberOrNot(stringUserWeight)) {
                userWeight = Integer.parseInt(stringUserWeight);                    
            }
        }

        // Checking if the user entered a number between 14 and 16
        String stringUserCalorieNumber = JOptionPane.showInputDialog(null, "Enter a number between 14"
                + "and 16. 14 meaning not active and 16 being very active");
        int userCaloriesNumber = 0;        
        if (numberOrNot(stringUserCalorieNumber)) {
            userCaloriesNumber = Integer.parseInt(stringUserCalorieNumber);
            while (!(userCaloriesNumber >= 14 && userCaloriesNumber <= 16 )) {
                JOptionPane.showMessageDialog(null, "You have not entered a number between 14 and 16");
                stringUserCalorieNumber = JOptionPane.showInputDialog(null, "Enter a number between 14"
                    + "and 16. 14 meaning not active and 16 being very active");
                if (numberOrNot(stringUserCalorieNumber)) {
                    userCaloriesNumber = Integer.parseInt(stringUserCalorieNumber);
                    while (!(userCaloriesNumber >= 14 && userCaloriesNumber <= 16 )) {                        
                        JOptionPane.showMessageDialog(null, "You have not entered a number between 14 and 16");
                        userCaloriesNumber =Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number between 14"
                            + "and 16. 14 meaning not active and 16 being very active")) ;                        
                    }
                }
            }
        }
        else if(!numberOrNot(stringUserCalorieNumber)) {
            while (!numberOrNot(stringUserCalorieNumber)) {
                JOptionPane.showMessageDialog(null, "You have not entered a number between 14 and 16");
                stringUserCalorieNumber = JOptionPane.showInputDialog(null, "Enter a number between 14"
                    + "and 16. 14 meaning not active and 16 being very active");                                
            }
            if (numberOrNot(stringUserCalorieNumber)) {
                userCaloriesNumber = Integer.parseInt(stringUserCalorieNumber);
                while (!(userCaloriesNumber >= 14 && userCaloriesNumber <= 16 )) {
                    JOptionPane.showMessageDialog(null, "You have not entered a number between 14 and 16");
                    stringUserCalorieNumber = JOptionPane.showInputDialog(null, "Enter a number between 14"
                        + "and 16. 14 meaning not active and 16 being very active");
                    if (numberOrNot(stringUserCalorieNumber)) {
                        userCaloriesNumber = Integer.parseInt(stringUserCalorieNumber);
                        while (!(userCaloriesNumber >= 14 && userCaloriesNumber <= 16 )) {                            
                            JOptionPane.showMessageDialog(null, "You have not entered a number between 14 and 16");
                            userCaloriesNumber =Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number between 14"
                                + "and 16. 14 meaning not active and 16 being very active")) ;
                        }
                    }
                }
            }
        }

        // Formulas to calculate macros
        double userPounds = Math.round(userWeight * 2.20462262);
        double userCalories = Math.round(userPounds * userCaloriesNumber);
        double userProteinGrams = Math.round(userPounds * 1.1);
        double userProteinCalories = Math.round(userProteinGrams * 4);
        double userFatGrams = Math.round(userPounds * 0.45);
        double userfatCalories = Math.round(userFatGrams * 9);
        double userCarbsCalories = (userCalories - userProteinCalories) - userfatCalories;
        double userCarbsGrams = Math.round(userCarbsCalories/4);        

        // Checking if he user entered gain or loose
        String userGainLooseOrMaintain = JOptionPane.showInputDialog(null, "Enter if you want to loose, gain or maintain weight");
        while (!userGainLooseOrMaintain.equals("gain") || !userGainLooseOrMaintain.equals("loose") || !userGainLooseOrMaintain.equals("maintain")) {
            if (userGainLooseOrMaintain.equals("gain")) {
                JOptionPane.showMessageDialog(null,userName +": \n" + userProteinGrams + "g Protein\n" + userCarbsGrams + "g Carbohydrates\n"
                + userFatGrams + "g fats\n" + userCalories + " Increase calories");
            }
            else if (userGainLooseOrMaintain.equals("loose")) {
                JOptionPane.showMessageDialog(null, userName + ": \n" + userProteinGrams + "g Protein\n" + userCarbsGrams + "g Carbohydrates\n"
                + userFatGrams + "g fats\n" + userCalories + " Decrease calories");
            }
            else if (userGainLooseOrMaintain.equals("maintain")) {
                JOptionPane.showMessageDialog(null, userName + ": \n" + userProteinGrams + "g Protein\n" + userCarbsGrams + "g Carbohydrates\n"
                + userFatGrams + "g fats\n" + "Maintain " + userCalories + " calories");                
            }
            else {
                JOptionPane.showMessageDialog(null, "Please choose between gain or loose");
                userGainLooseOrMaintain = JOptionPane.showInputDialog(null, "Enter if you want to loose or gain weight");
            } 
        }
    }
    
    // Try catch statement to see if the user entered a string or integer
    static boolean numberOrNot(String userCaloriesNumber){
        try {
            Integer.parseInt(userCaloriesNumber);
        } catch (Exception e) {
            return false;
        }
            return true;
    }
}
