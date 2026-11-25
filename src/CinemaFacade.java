import app.*;

public class CinemaFacade {

    private PopcornPopper _popper;
    private TheaterLights _lights;
    private Projector _projector;
    private Screen _screen;
    private Amplifier _amp;
    private Tuner _tuner;
    private DvdPlayer _dvd;
    private CdPlayer _cd;

    public CinemaFacade() {

        this._amp = new Amplifier("Top-O-Line Amplifier");
        this._tuner = new Tuner("Top-O-Line AM/FM Tuner", this._amp);
        this._dvd = new DvdPlayer("Top-O-Line DVD Player", this._amp);
        this._cd = new CdPlayer("Top-O-Line CD Player", this._amp);
        this._projector = new Projector("Top-O-Line Projector", this._dvd);
        this._lights = new TheaterLights("Theater Ceiling Lights");
        this._screen = new Screen("Theater Screen");
        this._popper = new PopcornPopper("Popcorn Popper");
    }

    public void startMovie() {

        this._popper.on();
        this._popper.pop();

        this._lights.dim(30);
        this._screen.down();

        this._projector.on();
        this._projector.wideScreenMode();

        this._amp.on();
        this._amp.setDvd(this._dvd);
        this._amp.setSurroundSound();
        this._amp.setVolume(5);

        this._dvd.on();
        this._dvd.play("James Cameron, Avatar (2009)");

        IO.println("> Enjoy the film!");
    }

    public void finishMovie() {

        this._popper.off();
        this._lights.on();
        this._screen.up();

        this._projector.off();
        this._amp.off();

        this._dvd.stop();
        this._dvd.eject();
        this._dvd.off();

        IO.println("> Movie mode turned off.");
    }

    public void startMusic() {

        this._lights.on();

        this._amp.on();
        this._amp.setVolume(5);
        this._amp.setCd(this._cd);
        this._amp.setStereoSound();

        this._cd.on();
        this._cd.play("Linkin Park, Hybrid Theory (2000)");

        IO.println("> Enjoy the music!");
    }

    public void finishMusic() {

        this._amp.off();
        this._cd.stop();
        this._cd.eject();
        this._cd.off();

        IO.println("> Music turned off.");
    }

    public void startRadio() {

        this._tuner.on();
        this._tuner.setFrequency(101.7);

        this._amp.on();
        this._amp.setVolume(5);
        this._amp.setTuner(_tuner);

        IO.println("> Enjoy the radio!");
    }

    public void finishRadio() {

        this._tuner.off();
        this._amp.off();

        IO.println("> Radio turned off");
    }

    public void openCinema() {
        this._lights.on();
        IO.println("Initiating...");
    }

    public void closeCinema() {

        this._lights.off();
        IO.println("> Goodnight!");

    }
}
