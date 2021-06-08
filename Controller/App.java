package Controller;
import dao.*;
import java.sql.SQLException;
import java.util.List;

import basic.AbstractConsoleApp;
import dao.InventoryDao;
import dao.NewsDao;
import dao.PGDao;
import dao.UserDao;
import entities.Inventory;
import entities.News;
import entities.PG;
import entities.User;

public class App extends AbstractConsoleApp {

	private static final String EXIT_CMD_VALUE = "0";
	private static final String DB_ADDRESS = "jdbc:mysql://localhost:3306/news?user=root&password=root";
	private static final String HELP_MENU = "Menù:" + "\t1 - Lista dei PG\n" + "\t2 - Crea un PG\n"
			+ "\t3 - Seleziona un PG\n";

	public static void main(String[] args) {
		new App().start();
	}
	
	// I Nostri dao, oggetti da cui recupero i dati
	private UserDao userDao;
	private NewsDao newsDao;
	private commentoDao commentoDao;
	
	// Queste proprietà mi servono per tener traccia
	// dello stato dell'applicativo
	// Dell'utente loggato in questo momento
	private User loggedUser;
	// Del personaggio che ha selezionato
	private News news;
	
	public App() {
		try {
			this.userDao = new UserDao(DB_ADDRESS);
			this.newsDao = new NewsDao(DB_ADDRESS);
			this.commentoDao = new commentoDao(DB_ADDRESS);
		} catch (SQLException e) {
			e.printStackTrace();
			println("Cannot connect to DB, Application terminated");
			// Forza la chiusura dell'applicazione java
			// il valore intero serve a specificare se 
			// la chiusura sia "positiva" o "negativa"
			System.exit(-1);
		}
	}

//	private boolean isGameStarted() {
//		return player != null;
//	}
	
	private boolean isLogged() {
		return loggedUser != null;
	}

	private void login() {
		loggedUser = userDao.login(nextLine("Username:"), nextLine("Password:"));
	}

	private void logout() {
		loggedUser = null;
	}

	@Override
	protected boolean exitCondition() {
		return cmd.equals(EXIT_CMD_VALUE);
	}

	@Override
	protected void run() {
		if (isLogged()) {
			loggedCmd();
		} else {
			notLoggedCmd();
		}
	}

	@Override
	public void start() {
		println("Benvenuto nel mondo di DND");
		println("Effettua il Login per proseguire");
		super.start();
	}

	private void loggedCmd() {
		if (isLogged()) {
			management();
		} else {
			management();
		}
	}

	private void management() {
		cmd = nextLine("Inserire comando");

		switch (cmd) {
		case "1":
			
			break;
		case "2":
			createNews();
			break;
		case "3":
		
			break;
		case "4":
		
			break;
		case "9":
			logout();
			ris = "Logged out";
		case "help":
			ris = HELP_MENU;
			break;
		}
	}

	
	private void playGame() {
		cmd = nextLine("News");
		switch (cmd) {
		case "1":
			createNews();
			break;
		case "help":
			// TODO da definire
			ris = "";
		case "9":
			news = null;
			ris = "Logged out";
			break;
		}
	}

	private void startGame() {
		int newsId = nextInt("Seleziona l'id del personaggio da utilizzare");
		news = newsDao.newsByIdOfUser(newsId, loggedUser.getId());
		if (news == null) {
			ris = "Non hai nessun PG con id " + newsId;
		} else {
			ris = "Benvenuto: " + news.getNews() + " Buona avventura!";
		}
	}


//	private void edit() {
//		int newsId = nextInt("Inserire l'id del personaggio da modificare");
		
//		News daModificare = NewsDao.pgByIdOfUser(newsId, loggedUser.getId());
//		if (daModificare == null) {
//			ris = "Non hai un pg con questo ID";
//			return;
//		}
//		
//		String nuovoNome = nextLine("Inserire il nuovo nome");
//		newsDao.updateName(newsId, nuovoNome);
//		ris = "Modifica effettuata";
//	}

	private void createNews() {
		println("Benvenuto nella creazione del personaggio");
		News newNews = new News(nextLine("titolo:"), nextLine("news:"), nextInt("datapubblicazione") ,nextLine ("autore"));
		println("ecco le tue news");
		String N ;
	
		ris = "Personaggio creato";
	}

//	private void myPGs() {
//		List<PG> pgs = pgDao.pgsOfUser(loggedUser.getId());
//		if (pgs.isEmpty()) {
//			ris = "Non hai ancora personaggi";
//		} else {
//			// renderizzo la lista dei pg
//			ris = pgs.toString();
//		}
//	}
//
	private void notLoggedCmd() {
		login();
		if (!isLogged()) {
			ris = "Credenziali errate, riprovare";
		} else {
			ris = "Benvenuto: " + loggedUser.getUsername();
		}
	}
//	
//	private List<Inventory> myInventory() {
//		return inventoryDao.inventoryOfPG(player.getId());
//	}
//
}
