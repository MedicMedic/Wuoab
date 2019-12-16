package Test;
import Models.LoginRegisterModel;
import Views.LoginRegisterView;
import Controllers.LoginRegisterController;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
    }
    
    public Test(){
        LoginRegisterModel myModel = new LoginRegisterModel();
        LoginRegisterView myView = new LoginRegisterView();
        myModel.addObserver(myView);
        System.out.println("233");
        LoginRegisterController myController = new LoginRegisterController();
        //pass the reference of model and view to the controllor
        myController.addModel(myModel);
        myController.addView(myView);
        //myController.initModel(start_value);
        myView.addController(myController);
    }
}
