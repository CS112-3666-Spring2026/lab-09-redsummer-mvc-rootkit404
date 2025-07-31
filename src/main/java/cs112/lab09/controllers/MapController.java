package cs112.lab09.controllers;

import cs112.lab09.MainApplication;
import cs112.lab09.models.Date;
import cs112.lab09.models.RevisedHistoricalEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MapController {

    protected void openPopupWindow(String location, RevisedHistoricalEvent rhEvent) throws IOException {
        //Get FXML file for popup window (event-view.fxml)
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("event-view.fxml"));
        Parent eventViewParent = loader.load();

        //Pass data to controller for given view
        EventController eventController = loader.getController();
        eventController.initData(location, rhEvent);

        //Create a new stage for a popup window
        Stage popupStage = new Stage();

        //Extra step: change modality of window
        popupStage.initModality(Modality.APPLICATION_MODAL);

        //Set scene
        popupStage.setScene(new Scene(eventViewParent));

        //Show scene
        popupStage.show();
    }

    //NOTE: redundance in methods
    @FXML
    protected void onSanFranciscoCaButtonClick() throws IOException {
        RevisedHistoricalEvent sfEvent = new RevisedHistoricalEvent(new RevisedHistoricalEvent("A minor riot " +
                "between Black and white soldiers occurred in the Presidio in San Francisco", new Date(5,15,1919),
                "A minor riot between Black and white soldiers occurred in the Presidio in San Francisco " +
                        "after a dispute about a Thai soldier who was moved from the \"colored quarters\" to the white " +
                        "military housing. Despite defending our country, housing for Black soldiers was not only " +
                        "segregated but often inferior. Black soldiers also faced increased attacks and other forms of " +
                        "discrimination upon returning home.", "\n\nSoure: https://cdr.lib.unc.edu/downloads/1c18dm56n?locale=en"));

        this.openPopupWindow("San Francisco, CA", sfEvent);
    }

    @FXML
    protected void onBisbeeAzButtonClick() throws IOException {
        RevisedHistoricalEvent bizbeeAz = new RevisedHistoricalEvent(
                "Local police in Bisbee, Arizona attacked the 10th U.S, Cavalry, an African-American unit known as the " +
                "\"Buffalo Soldiers,\" formed in 1866.", new Date(7,13,1919),
                "Although sources are limited, the attack occurred on the eve of celebrations meant to " +
                        "honor returning soldiers (ike in Norfolk, Virginia).",
                "\n\nSoure: https://cdr.lib.unc.edu/downloads/1c18dm56n?locale=en");

        this.openPopupWindow("Bizbee, AZ", bizbeeAz);
    }
}
