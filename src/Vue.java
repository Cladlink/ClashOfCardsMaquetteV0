// Affichage du plateau de jeu

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.border.*;

public class Vue extends JFrame
{
    public int i, j ;

    // cartes du joueur pour la maquette
    public ImageIcon empty;

    public ImageIcon[] teamBleue =
        {
            new ImageIcon(getClass().getResource("Images/Aiolia_Bleu.jpg")),
            new ImageIcon(getClass().getResource("Images/Aioros_Bleu.jpg")),
            new ImageIcon(getClass().getResource("Images/Aldebaran_Bleu.jpg")),
            new ImageIcon(getClass().getResource("Images/Algol_Bleu.jpg")),
            new ImageIcon(getClass().getResource("Images/Aphrodite_Bleu.jpg"))
        };

    // carte de l'adversaire pour la maquette
    public ImageIcon[] teamRouge =
        {
            new ImageIcon(getClass().getResource("Images/Aiolia_Rouge.jpg")),
            new ImageIcon(getClass().getResource("Images/Aioros_Rouge.jpg")),
            new ImageIcon(getClass().getResource("Images/Aldebaran_Rouge.jpg")),
            new ImageIcon(getClass().getResource("Images/Algol_Rouge.jpg")),
            new ImageIcon(getClass().getResource("Images/Aphrodite_Rouge.jpg"))
        };

    // images des scores
    public ImageIcon[] scoreBleu =
            {
                    new ImageIcon(getClass().getResource("Images/Score/Score_Bleu_Mini_0.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Bleu_Mini_1.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Bleu_Mini_2.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Bleu_Mini_3.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Bleu_Mini_4.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Bleu_Mini_5.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Bleu_Mini_6.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Bleu_Mini_7.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Bleu_Mini_8.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Bleu_Mini_9.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Bleu_Mini_10.png"))
            };
    public ImageIcon[] scoreRouge =
            {
                    new ImageIcon(getClass().getResource("Images/Score/Score_Rouge_Mini_0.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Rouge_Mini_1.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Rouge_Mini_2.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Rouge_Mini_3.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Rouge_Mini_4.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Rouge_Mini_5.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Rouge_Mini_6.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Rouge_Mini_7.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Rouge_Mini_8.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Rouge_Mini_9.png")),
                    new ImageIcon(getClass().getResource("Images/Score/Score_Rouge_Mini_10.png"))
            };

    // éléments du chat
    public JButton envoyer ;
    public JTextField text ;

    // cartes des joueurs
    public JLabel[] joueur;
    public JLabel[] adversaire;

    // scores des joueurs
    public JLabel scoreJoueur ;
    public JLabel scoreAdversaire ;

    // plateau de jeu
    public JLabel[][] plateau;

    // Les JPanels
    public JPanel panoCartesJoueur;
    public JPanel panoPlace;
    public JPanel panoCartesAdversaire;
    public JPanel panoPlateau;
    public JPanel panoChat;
    public JPanel panoJoueur;
    public JPanel panoAdversaire;
    public JPanel panoEspaces;
    public JPanel panoPlaceScoreCartesJoueur;
    public JPanel panoPlaceScoreCartesAdversaire;

    // définition de la vue
    public Vue(Model model)
    {
        initAttribut();
        creerWidget();


        setSize(1100,700);
        setVisible(true);
        setResizable(false);// important pour pas avoir a gérer la redifinition d'écran
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initAttribut()
    {
        empty = new ImageIcon(getClass().getResource("Images/Empty.jpg"));

        envoyer = new JButton("Envoyer");
        text = new JTextField();
        text.setColumns(40);

        joueur = new JLabel[5];
        adversaire = new JLabel[5];


        scoreJoueur = new JLabel(scoreBleu[5]);
        scoreAdversaire = new JLabel(scoreRouge[5]);

        // permet de faire une case plus grande pour le score
        scoreJoueur.setMaximumSize(new Dimension(100,100));
        scoreAdversaire.setMaximumSize(new Dimension(100,100));

        plateau = new JLabel[3][3];

        for(i=0; i<plateau.length;i++)
        {
            for (j=0; j<plateau[i].length;j++)
            {
                plateau[i][j]=new JLabel(empty);
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

        // permet qu'il n'y est pas d'espaces entre les cartes placées sur le plateau
        panoEspaces = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panoEspaces.add(panoPlateau);

        // panels de l'adversaire et du joueur
        panoCartesAdversaire = new JPanel();
        panoCartesJoueur = new JPanel();

        // organise les cartes horizontalement
        panoCartesAdversaire.setLayout(new BoxLayout(panoCartesAdversaire, BoxLayout.Y_AXIS));
        panoCartesJoueur.setLayout(new BoxLayout(panoCartesJoueur, BoxLayout.Y_AXIS));

        // gère l'espacement entre le score et les cartes
        panoCartesAdversaire.add(Box.createRigidArea(new Dimension(0, 200)));
        panoCartesJoueur.add(Box.createRigidArea(new Dimension(0, 200)));

        // placement des cartes dans leurs panel respectifs
        for(i=0; i<adversaire.length; i++)
        {
            if(adversaire[i]!=null)
            {
                panoCartesAdversaire.add(Box.createRigidArea(new Dimension(0, -150)));
                adversaire[i].setOpaque(false);
                panoCartesAdversaire.add(adversaire[i]);
            }

        }
        for(i=0; i<joueur.length; i++)
        {
            if(joueur[i]!=null)
            {
                panoCartesJoueur.add(Box.createRigidArea(new Dimension(0, -150)));
                joueur[i].setOpaque(false);
                panoCartesJoueur.add(joueur[i]);
            }
        }

        // permet de placer le score et les cartes à l'intérieur du panel panoJoueur
        panoPlaceScoreCartesJoueur = new JPanel(new BorderLayout());
        panoPlaceScoreCartesJoueur.add(scoreJoueur, BorderLayout.NORTH);
        panoPlaceScoreCartesJoueur.add(panoCartesJoueur, BorderLayout.SOUTH);

        panoPlaceScoreCartesAdversaire = new JPanel(new BorderLayout());
        panoPlaceScoreCartesAdversaire.add(scoreAdversaire, BorderLayout.NORTH);
        panoPlaceScoreCartesAdversaire.add(panoCartesAdversaire, BorderLayout.SOUTH);

        // panel qui permet d'afficher une marge sur les côtés
        panoJoueur = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panoJoueur.add(panoPlaceScoreCartesJoueur);
        panoAdversaire = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panoAdversaire.add(panoPlaceScoreCartesAdversaire);

        // panel du chat (miaou)
        panoChat = new JPanel();
        panoChat.add(text);
        panoChat.add(envoyer);

        // panel principal
        panoPlace = new JPanel(new BorderLayout());
        panoPlace.add(panoJoueur, BorderLayout.WEST);
        panoPlace.add(panoAdversaire, BorderLayout.EAST);
        panoPlace.add(panoChat, BorderLayout.SOUTH);
        panoPlace.add(panoEspaces, BorderLayout.CENTER);

        setContentPane(panoPlace);
	}

    public void setMouseControler(MouseMotionListener e)
    {
        for(i=0; i<adversaire.length;i++)
        {
            adversaire[i].addMouseMotionListener(e);
            joueur[i].addMouseMotionListener(e);

        }
    }
    public void setMouseButton(MouseListener e)
    {
        for(i=0; i<adversaire.length;i++)
        {
            if(adversaire[i]!= null)
                adversaire[i].addMouseListener(e);
        }
        for(i=0; i<joueur.length;i++)
        {
            if(joueur[i]!=null)
                joueur[i].addMouseListener(e);
        }
        for(i=0; i<plateau.length;i++)
        {
            for(j=0; j<plateau[i].length;j++)
            {

                if (plateau[i][j].getIcon() == empty)
                    plateau[i][j].addMouseListener(e);
            }
        }
    }
}