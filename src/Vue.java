// Affichage du plateau de jeu

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.*;

public class Vue extends JFrame
{
	private int i, j ;
    // cartes du joueur pour la maquette
	private ImageIcon[] teamBleue =
	{
		new ImageIcon(getClass().getResource("Images/Athena_Bleu.jpg")),
		new ImageIcon(getClass().getResource("Images/Hades_Bleu.jpg")),
		new ImageIcon(getClass().getResource("Images/Shion_Bleu.jpg")),
		new ImageIcon(getClass().getResource("Images/Shiryu_Bleu.jpg")),
		new ImageIcon(getClass().getResource("Images/VieuxMaitre_Bleu.jpg"))
	};

    // carte de l'adversaire pour la maquette
	private ImageIcon[] teamRouge =
	{
		new ImageIcon(getClass().getResource("Images/Aiolia_Rouge.jpg")),
		new ImageIcon(getClass().getResource("Images/Aioros_Rouge.jpg")),
		new ImageIcon(getClass().getResource("Images/Aldebaran_Rouge.jpg")),
		new ImageIcon(getClass().getResource("Images/Algol_Rouge.jpg")),
		new ImageIcon(getClass().getResource("Images/Aphrodite_Rouge.jpg"))
	};

    // images des scores
    private ImageIcon scoreRouge;
    private ImageIcon scoreBleu;


    // éléments du chat
	private JButton envoyer ;
	private JTextField text ;

    // cartes des joueurs
	private JLabel[] joueur;
	private JLabel[] adversaire;

    // scores des joueurs
    private JLabel scoreJoueur ;
    private JLabel scoreAdversaire ;

    // plateau de jeu
	private JLabel[][] plateau;

    // Les JPanels
	private JPanel panoCartesJoueur;
	private JPanel panoPlace;
	private JPanel panoCartesAdversaire;
	private JPanel panoPlateau;
	private JPanel panoChat;
    private JPanel panoJoueur;
    private JPanel panoAdversaire;

    // définition de la vue
	public Vue(Model model)
	{
		initAttribut();
		creerWidget();

		setSize(800,700);
		setVisible(true);
		setResizable(false);// important pour pas avoir a gérer la redifinition d'écran
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initAttribut()
	{

		envoyer = new JButton("Envoyer");
		text = new JTextField();
		text.setColumns(40);

        joueur = new JLabel[5];
        adversaire = new JLabel[5];

        scoreRouge = new ImageIcon(getClass().getResource("Images/Score_Rouge_Mini.png"));
        scoreBleu = new ImageIcon(getClass().getResource("Images/Score_Bleu_Mini.png"));

        scoreJoueur = new JLabel(scoreBleu);
        scoreAdversaire = new JLabel(scoreRouge);

        // permet de faire une case plus grande pour le score
        scoreJoueur.setMaximumSize(new Dimension(100,100));
        scoreAdversaire.setMaximumSize(new Dimension(100,100));

		plateau = new JLabel[3][3];

        for(i=0; i<plateau.length;i++)
        {
            for (j=0; j<plateau[i].length;j++)
            {
                plateau[i][j]=new JLabel(teamBleue[0]);
                plateau[i][j].setMaximumSize(new Dimension(50, 50));// 50 est un test
            }
        }
		for(i=0; i<joueur.length; i++)
		{
			joueur[i] = new JLabel(teamBleue[i]);
			adversaire[i] = new JLabel(teamRouge[i]);
		}
	}

	public void creerWidget()
	{
        // panel du plateau
		panoPlateau = new JPanel(new GridLayout(3,3));
		Border blackline = BorderFactory.createLineBorder(Color.black,1);

        for(i=0; i<plateau.length;i++)
        {
            for (j=0; j<plateau[i].length;j++)
            {
                plateau[i][j].setBorder(blackline);
                panoPlateau.add(plateau[i][j]);
            }
        }

        // panel de l'adversaire et du joueur
		panoCartesAdversaire = new JPanel();
        panoCartesJoueur = new JPanel();

        //
		panoCartesAdversaire.setLayout(new BoxLayout(panoCartesAdversaire, BoxLayout.Y_AXIS));
        panoCartesJoueur.setLayout(new BoxLayout(panoCartesJoueur, BoxLayout.Y_AXIS));

		//ajout des scores
		panoCartesAdversaire.add(scoreJoueur);
        panoCartesJoueur.add(scoreAdversaire);

        // gère l'espacement êntre le score et les cartes
        panoCartesAdversaire.add(Box.createRigidArea(new Dimension(0, 80)));
        panoCartesJoueur.add(Box.createRigidArea(new Dimension(0, 80)));

        // placement des cartes dans leurs panel respectifs
		for(i=0; i<adversaire.length; i++)
		{
            panoCartesAdversaire.add(Box.createRigidArea(new Dimension(0, -10)));
            panoCartesAdversaire.add(adversaire[i]);

            panoCartesJoueur.add(Box.createRigidArea(new Dimension(0, -10)));
            panoCartesJoueur.add(joueur[i]);
		}
        panoJoueur = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panoJoueur.add(panoCartesJoueur);

        panoAdversaire = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panoAdversaire.add(panoCartesAdversaire);
        // panel du chat (miaou)
		panoChat = new JPanel();
		panoChat.add(text);
		panoChat.add(envoyer);

        // panel principal
		panoPlace = new JPanel(new BorderLayout());
		panoPlace.add(panoJoueur, BorderLayout.WEST);
		panoPlace.add(panoAdversaire, BorderLayout.EAST);
		panoPlace.add(panoChat, BorderLayout.SOUTH);
		panoPlace.add(panoPlateau, BorderLayout.CENTER);

		setContentPane(panoPlace);

	}
}