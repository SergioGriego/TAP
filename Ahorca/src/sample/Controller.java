package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.Locale;
import java.util.Random;

public class Controller {
    @FXML
    HBox contenedor;
    @FXML
    AnchorPane padre;
    String[] palabras = {"PERRO", "GATO", "TORTUGA", "PATO", "CONEJO", "PEZ", "COCODRILO"};
    TextField[] arrayTxt = null;
    ImageView[] arrayImg = new ImageView[6];
    int intentos=6;

    @FXML
    protected void initialize() {
        Random random = new Random();
        int aleatorio = random.nextInt(6);
        String palabra = palabras[aleatorio].toLowerCase();
        System.out.println(palabra);
        arrayTxt = new TextField[palabra.length()];
        int ayuda = 1;//Letras de ayuda

        for (int x = 0; x < palabra.length(); x++) {
            arrayTxt[x] = new TextField();
            //TextField txt1=new TextField();
            arrayTxt[x].setPrefWidth(50);
            arrayTxt[x].setPrefHeight(50);
            arrayTxt[x].setId("txt-" + x + "-" + palabra.charAt(x));
            arrayTxt[x].setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    TextField textField = (TextField) event.getTarget(); //Convertir en textfield
                    String[] nombre = textField.getId().split("-");
                    if (nombre[2].equals(textField.getText().toLowerCase())) {
                        System.out.println("CORRECTO" + textField.getId());
                        System.out.println("Has Ganado");
                        textField.setDisable(true);
                    } else {
                        System.out.println("INCORRECTO" + textField.getId());
                        textField.setText("");
                        --intentos;
                        if (intentos==5){
                            pintarCabeza();
                        }else if (intentos==4){
                            pintarCuerpo();
                        }else if (intentos==3){
                            pintarBrazoI();
                        }else if (intentos==2){
                            pintarBrazoD();
                        }else if(intentos==1){
                            pintarPiernaD();
                        }else if(intentos==0){
                            pintarPiernaI();
                            System.out.println("Has Perdido");
                            Alert alerta=new Alert(Alert.AlertType.ERROR);
                            alerta.setTitle("MALAS NOTICIAS");
                            alerta.setContentText("Ya no puedes jugar, la palabra era "+palabra);
                            alerta.show();
                            textField.setDisable(true);
                        }
                    }
                    // System.out.println(textField.getId());
                }
            });
            contenedor.getChildren().add(arrayTxt[x]);
        }
    }

    public void pintarCabeza() {
        arrayImg[0] = new ImageView(new Image("sample/imagenes/cabeza.png"));
        arrayImg[0].setFitHeight(70);
        arrayImg[0].setFitWidth(70);
        arrayImg[0].setLayoutX(230);
        arrayImg[0].setLayoutY(100);
        padre.getChildren().addAll(arrayImg[0]);
    }
    public void pintarBrazoD() {
        arrayImg[2] = new ImageView(new Image("sample/imagenes/brazoDerecho.png"));
        arrayImg[2].setFitHeight(70);
        arrayImg[2].setFitWidth(70);
        arrayImg[2].setLayoutX(285);
        arrayImg[2].setLayoutY(135);
        padre.getChildren().addAll(arrayImg[2]);
    }
    public void pintarBrazoI() {
        arrayImg[3] = new ImageView(new Image("sample/imagenes/brazoIzquierdo.png"));
        arrayImg[3].setFitHeight(70);
        arrayImg[3].setFitWidth(70);
        arrayImg[3].setLayoutX(175);
        arrayImg[3].setLayoutY(135);
        padre.getChildren().addAll(arrayImg[3]);
    }
    public void pintarPiernaI() {
        arrayImg[4] = new ImageView(new Image("sample/imagenes/piernaIzquierda.png"));
        arrayImg[4].setFitHeight(70);
        arrayImg[4].setFitWidth(70);
        arrayImg[4].setLayoutX(200);
        arrayImg[4].setLayoutY(240);
        padre.getChildren().addAll(arrayImg[4]);
    }
    public void pintarPiernaD() {
        arrayImg[5] = new ImageView(new Image("sample/imagenes/piernaDerecha.png"));
        arrayImg[5].setFitHeight(70);
        arrayImg[5].setFitWidth(70);
        arrayImg[5].setLayoutX(260);
        arrayImg[5].setLayoutY(240);
        padre.getChildren().addAll(arrayImg[5]);
    }


    public void pintarCuerpo() {

            arrayImg[1] = new ImageView(new Image("sample/imagenes/cuerpo.png"));
            arrayImg[1].setFitHeight(70);
            arrayImg[1].setFitWidth(70);
            arrayImg[1].setLayoutX(230);
            arrayImg[1].setLayoutY(170);

            padre.getChildren().addAll(arrayImg[1]);




//        ////////////
//        ImageView cabeza=new ImageView(new Image("sample/imagenes/cabeza.png"));
//        cabeza.setFitHeight(70);
//        cabeza.setFitWidth(70);
//        cabeza.setLayoutX(230);cabeza.setLayoutY(100);
//
//        ImageView cuerpo=new ImageView(new Image("sample/imagenes/cuerpo.png"));
//        cuerpo.setFitHeight(70);
//        cuerpo.setFitWidth(70);
//        cuerpo.setLayoutX(230);cuerpo.setLayoutY(170);
//
//        ImageView brazoD=new ImageView(new Image("sample/imagenes/brazoDerecho.png"));
//        brazoD.setFitHeight(70);
//        brazoD.setFitWidth(70);
//        brazoD.setLayoutX(285);brazoD.setLayoutY(135);
//
//        ImageView brazoI=new ImageView(new Image("sample/imagenes/brazoIzquierdo.png"));
//        brazoI.setFitHeight(70);
//        brazoI.setFitWidth(70);
//        brazoI.setLayoutX(175);brazoI.setLayoutY(135);
//
//        ImageView piernaI=new ImageView(new Image("sample/imagenes/piernaIzquierda.png"));
//        piernaI.setFitHeight(70);
//        piernaI.setFitWidth(70);
//        piernaI.setLayoutX(200);piernaI.setLayoutY(240);
//
//        ImageView piernaD=new ImageView(new Image("sample/imagenes/piernaDerecha.png"));
//        piernaD.setFitHeight(70);
//        piernaD.setFitWidth(70);
//        piernaD.setLayoutX(260);piernaD.setLayoutY(240);
//        padre.getChildren().addAll(cabeza,cuerpo,brazoD,brazoI,piernaI,piernaD);
//        ////////


    }
}
