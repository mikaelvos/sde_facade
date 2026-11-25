public class Main {

    public static void main(String[] args ){

        CinemaFacade cinemaFacade = new CinemaFacade();

        cinemaFacade.openCinema();

        IO.println("Welcome to your Cinema");

        cinemaFacade.startMovie();

        IO.println("> Watching a movie......");

        cinemaFacade.finishMovie();

        IO.println("> ...");

        cinemaFacade.startMusic();

        IO.println("> Listening to music.......");

        cinemaFacade.finishMusic();

        IO.println("> ....");

        cinemaFacade.startRadio();

        IO.println("> Listening to radio ......");

        cinemaFacade.finishRadio();

        IO.println("> All done listening!");

        cinemaFacade.closeCinema();
    }
}
