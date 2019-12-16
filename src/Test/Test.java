package src.Test;
import src.Models.LoginRegisterModel;
import src.Views.LoginRegisterView;
import src.Controllers.LoginRegisterController;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
    }
    
    public Test(){
        LoginRegisterModel myModel = new LoginRegisterModel();
        LoginRegisterView myView = new LoginRegisterView();
        myModel.addObserver(myView);
        
        LoginRegisterController myController = new LoginRegisterController();
        //pass the reference of model and view to the controllor
        myController.addModel(myModel);
        myController.addView(myView);
        //myController.initModel(start_value);
        myView.addController(myController);
    }
}
