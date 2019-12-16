package src.Execution;

import src.Controllers.LoginRegisterController;
import src.Models.LoginRegisterModel;
import src.Views.LoginRegisterView;

import java.sql.*;

public class User implements Runnable {


    // init block
    {

    }

    // constructors
    public User() {
//        autoConnectWuoabDB();


        // close the connection

    }

    // methods
    @Override
    public void run() {
//        LoginRegisterModel myModel = new LoginRegisterModel();
        LoginRegisterView myView = new LoginRegisterView();
//        myModel.addObserver(myView);

        LoginRegisterController myController = new LoginRegisterController();
        //pass the reference of model and view to the controllor
//        myController.addModel(myModel);
        myController.addView(myView);
        //myController.initModel(start_value);
        myView.addController(myController);
    }


}
