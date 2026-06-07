/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

/**
 *
 * @author danda
 */
public class TelaSom extends JDialog{
   private JSlider volumeSlider;
    private JLabel volumeLabel;

    public TelaSom(java.awt.Frame parent) {
        super(parent, "Controle de Som", true);

        setSize(350, 160);
        setLocationRelativeTo(parent);
        setResizable(false);

        int volumeInicial = MusicaFundo.getVolumeAtual();

        volumeLabel = new JLabel("Volume: " + volumeInicial + "%", SwingConstants.CENTER);

        volumeSlider = new JSlider(0, 100, volumeInicial);
        volumeSlider.setMajorTickSpacing(25);
        volumeSlider.setMinorTickSpacing(5);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);

        volumeSlider.addChangeListener(e -> {
            int volume = volumeSlider.getValue();
            MusicaFundo.setVolume(volume);
            volumeLabel.setText("Volume: " + volume + "%");
        });

        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.add(volumeLabel, BorderLayout.NORTH);
        painel.add(volumeSlider, BorderLayout.CENTER);
        painel.setPreferredSize(new Dimension(320, 120));

        add(painel);
    }
    }

