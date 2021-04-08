import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        // Creating 1st album
        Album album = new Album("The hybrid theory", "Linkin Park");
        album.addSong("Breaking the habbit", 4.2);
        album.addSong("One step closer", 2.37);
        album.addSong("With you", 3.23);
        album.addSong("Papercut", 3.05);
        album.addSong("Crawling", 3.10);
        album.addSong("In the end", 3.07);
        albums.add(album);


        // Creating 2nd album
        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 4.23);
        album.addSong("I put finger on you", 3.23);
        album.addSong("Lets go", 3.54);
        album.addSong("Evil walks", 3.67);
        album.addSong("C.O.D.", 3.12);
        album.addSong("Breaking the rules", 4.13);
        album.addSong("Night of the long knives", 4.05);
        albums.add(album);

        // Creating and adding songs to playlist for test
        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("With you", playList);
        albums.get(0).addToPlayList("Papercut", playList);
        albums.get(0).addToPlayList("Crawling", playList);
        albums.get(0).addToPlayList("Breakings the rules", playList);
        albums.get(1).addToPlayList(6, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(10, playList);

        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing: \n " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("Reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("Reached the start of the playlist");
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("Now at start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("Now at the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions \npress");
        System.out.println("0 - to quit\n" +
                "1 - Next song\n" +
                "2 - Previous song\n" +
                "3 - Replay current song\n" +
                "4 - List of songs in the playlist\n" +
                "5 - Print available actions\n" +
                "6 - Remove song");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("============================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("============================");
    }

}
