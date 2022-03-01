package com.example.entregapokemon1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javafx.scene.control.ButtonType;

public class Ventana2Controller {

    Pokemon pokemonSeleccionado;
    Pokemon2 oponente;

    ArrayList<Pokemon2> ListaPokemon = new ArrayList<>(); //CREAR ARRAYLIST PARA HACER DE FORMA RANDOM LOS ENEMIGOS

    Fondo f1 = new Fondo(new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\Campo_de_batalla_DPPt_2.png"));

    Pokemon2 p21 = new Pokemon2("Carnivine", "Nv 45", 248, 248, new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\carnivine.gif"));
    Pokemon2 p22 = new Pokemon2("Carracosta", "Nv 34", 267, 267, new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\carracosta.gif"));
    Pokemon2 p23 = new Pokemon2("Chinchar", "Nv 50", 300, 300, new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\chimchar.gif"));
    Pokemon2 p24 = new Pokemon2("Chesnaught", "NV 24", 190, 190, new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\chesnaught.gif"));

    @FXML
    ImageView fondoInterfaz;

    @FXML
    AnchorPane btPrincipales;
    @FXML
    Button btCurar;
    @FXML
    Button btAtacar;

    @FXML
    AnchorPane btSecundarios;
    @FXML
    Button btAtaque1;
    @FXML
    Button btAtaque2;
    @FXML
    Button btAtaque3;
    @FXML
    Button btCancelar;

    @FXML
    ImageView miPokemon;
    @FXML
    Label nombreAliado;
    @FXML
    Label nivelAliado;
    @FXML
    ProgressBar vidaAliado;
    @FXML
    AnchorPane panelAliado;
    @FXML
    Text PSAliado;

    @FXML
    ImageView pokemonEnemigo;
    @FXML
    Label nombreEnemigo;
    @FXML
    Label nivelEnemigo;
    @FXML
    ProgressBar vidaEnemigo;
    @FXML
    AnchorPane panelEnemigo;
    @FXML
    Text PSEnemigo;

    private HelloController HelloController; //COGER CONFIGURACION DE LA PRIMERA VENTANA

    public void Pkm(Pokemon pokemonSeleccionado) {

        Image fond1 = new Image(f1.fondo1.toURI().toString());
        fondoInterfaz.setImage(fond1);

        this.pokemonSeleccionado = pokemonSeleccionado;

        Image imagen1 = new Image(pokemonSeleccionado.foto.toURI().toString());
        miPokemon.setImage(imagen1);
        nombreAliado.setText(pokemonSeleccionado.nombre);
        nivelAliado.setText(pokemonSeleccionado.nivel);
        vidaAliado.setProgress(pokemonSeleccionado.vidaRestante / pokemonSeleccionado.vida);

        //AÑADIR LOS POKEMONS ENEMIGOS AL ARRAYLIST
        ListaPokemon.add(p21);
        ListaPokemon.add(p22);
        ListaPokemon.add(p23);
        ListaPokemon.add(p24);

        oponente = ListaPokemon.get((int) (Math.random() * ListaPokemon.size())); //SACAR DE FORMA RANDOM LOS POKEMONS

        Image imagen2 = new Image(oponente.foto2.toURI().toString());
        pokemonEnemigo.setImage(imagen2);
        nombreEnemigo.setText(oponente.nombre2);
        vidaEnemigo.setProgress(oponente.vidaRestante2 / oponente.vida2);
        nivelEnemigo.setText(oponente.nivel2);

        btAtaque1.setVisible(false);
        btAtaque2.setVisible(false);
        btAtaque3.setVisible(false);
        btCancelar.setVisible(false);

    }

    @FXML
    protected void btAtaques() {

        System.out.println("BotonAtaqueSeleccionado");
        btAtacar.setVisible(false);
        btCurar.setVisible(false);
        btAtaque1.setVisible(true);
        btAtaque2.setVisible(true);
        btAtaque3.setVisible(true);
        btCancelar.setVisible(true);

    }

    @FXML
    protected void subirVida() {

        System.out.println("BotonVidaSeleccionado");
        Random r = new Random();

        int rdmVida = r.nextInt(50) + 25;
        pokemonSeleccionado.vidaRestante += rdmVida;
        vidaAliado.setProgress(pokemonSeleccionado.vidaRestante / pokemonSeleccionado.vida);
        System.out.println("Curacion1 de " + rdmVida);
        HelloController.actualizarInterfaz();

        rdmVida = r.nextInt(50) + 25;
        oponente.vidaRestante2 += rdmVida;
        vidaEnemigo.setProgress(oponente.vidaRestante2 / oponente.vida2);
        System.out.println("Curacion2 de " + rdmVida);

    }

    @FXML
    protected void btSeguro() {

        int danoSeguro = 20;

        System.out.println("BotonSeguroSeleccionado");

        pokemonSeleccionado.vidaRestante -= danoSeguro;
        vidaAliado.setProgress(pokemonSeleccionado.vidaRestante / pokemonSeleccionado.vida);
        System.out.println("Dano seguro1 de " + danoSeguro);
        HelloController.actualizarInterfaz();
        controlarDeLaVidaAliado();

        oponente.vidaRestante2 -= danoSeguro;
        vidaEnemigo.setProgress(oponente.vidaRestante2 / oponente.vida2);
        System.out.println("Dano seguro2 de " + danoSeguro);
        controlarDeLaVidaEnemigo();}


    @FXML
    protected void btArriesgado() {

        System.out.println("BotonArriesgadoSeleccionado");
        Random r = new Random();

        int rdmArriesgado = r.nextInt(15) + 10;
        pokemonSeleccionado.vidaRestante -= rdmArriesgado;
        vidaAliado.setProgress(pokemonSeleccionado.vidaRestante / pokemonSeleccionado.vida);
        System.out.println("Dano arriesgado1 de " + rdmArriesgado);
        HelloController.actualizarInterfaz();
        controlarDeLaVidaAliado();

        rdmArriesgado = r.nextInt(15) + 10;
        oponente.vidaRestante2 -= rdmArriesgado;
        vidaEnemigo.setProgress(oponente.vidaRestante2 / oponente.vida2);
        System.out.println("Dano arriesgado2 de " + rdmArriesgado);
        controlarDeLaVidaEnemigo();

    }

    @FXML
    protected void btMuyArriesgado() {

        System.out.println("BotonMuyArriesgadoSeleccionado");
        Random r = new Random();

        int rdmMuyArriesgado = r.nextInt(50);
        pokemonSeleccionado.vidaRestante -= rdmMuyArriesgado;
        vidaAliado.setProgress(pokemonSeleccionado.vidaRestante / pokemonSeleccionado.vida);
        System.out.println("Dano muy arriesgado1 de " + rdmMuyArriesgado);
        HelloController.actualizarInterfaz();
        controlarDeLaVidaAliado();

        rdmMuyArriesgado = r.nextInt(50);
        oponente.vidaRestante2 -= rdmMuyArriesgado;
        vidaEnemigo.setProgress(oponente.vidaRestante2 / oponente.vida2);
        System.out.println("Dano muy arriesgado2 de " + rdmMuyArriesgado);
        controlarDeLaVidaEnemigo();

    }

    @FXML
    protected void btCancelar() {

        System.out.println("BotonCancelarSeleccionado");
        btAtacar.setVisible(true);
        btCurar.setVisible(true);
        btAtaque1.setVisible(false);
        btAtaque2.setVisible(false);
        btAtaque3.setVisible(false);
        btCancelar.setVisible(false);

    }

    @FXML
    protected void cambiartextoEnemigo() {
        PSEnemigo.setText(String.valueOf(oponente.vidaRestante2));
    }

    @FXML
    protected void cambiartextoEnemigo2() {
        PSEnemigo.setText("PS");
    }

    @FXML
    protected void cambiartextoAliado() {
        PSAliado.setText(String.valueOf(pokemonSeleccionado.vidaRestante));
    }

    @FXML
    protected void cambiartextoAliado2() {
        PSAliado.setText("PS");
    }

    private void controlarDeLaVidaAliado () {

        if (pokemonSeleccionado.vidaRestante <= 0) {
            showAlert1(alertaPokemonAliado(oponente));
        }
    }

        private void controlarDeLaVidaEnemigo() {

            if (oponente.vidaRestante2 <= 0) {
                showAlert2(alertaPokemonEnemigo(pokemonSeleccionado));
            }

        }

    private void showAlert1(Alert alert) {

        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.get() == ButtonType.NO) {
            System.exit(0);
        }else{
            HelloController.stage2.close();
        }
    }
    private void showAlert2(Alert alert) {

        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.get() == ButtonType.NO) {
            System.exit(0);
        }else{
            HelloController.stage2.close();
        }
    }


    public Alert alertaPokemonEnemigo(Pokemon pokemonSeleccionado) {

            Alert customAlert = new Alert(Alert.AlertType.NONE);

            customAlert.setTitle("Pokemon Ganador");
            customAlert.setContentText("El pokemon ganador es " +pokemonSeleccionado.nombre);
            customAlert.setGraphic(new ImageView(new Image(pokemonSeleccionado.foto.toURI().toString())));
            customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.NEXT, ButtonType.CLOSE);
            showAlert1(customAlert);

            return customAlert;

    }

    public Alert alertaPokemonAliado(Pokemon2 oponente) {

        Alert customAlert = new Alert(Alert.AlertType.NONE);

        customAlert.setTitle("Pokemon Ganador");
        customAlert.setContentText("El pokemon ganador es " +oponente.nombre2);
        customAlert.setGraphic(new ImageView(new Image(oponente.foto2.toURI().toString())));
        customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.NEXT, ButtonType.CANCEL);
        showAlert2(customAlert);

        return customAlert;

    }

    void enviarDatos(HelloController HelloController){
        this.HelloController=HelloController;
    }

}

    class Pokemon2 {

        String nombre2;
        Integer vida2;
        File foto2;
        float vidaRestante2;
        String nivel2;

        public Pokemon2(String nombre2, String nivel2, Integer vida2, float vidaRestante2, File foto2) {

            this.nombre2 = nombre2;
            this.nivel2 = nivel2;
            this.vida2 = vida2;
            this.foto2 = foto2;
            this.vidaRestante2 = vidaRestante2;

        }

    }

    class Fondo {

        File fondo1;

        public Fondo(File fondo1) {
            this.fondo1 = fondo1;
        }

    }