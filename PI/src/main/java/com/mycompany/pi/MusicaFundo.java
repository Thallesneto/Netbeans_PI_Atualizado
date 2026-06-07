/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pi;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author danda
 */
public class MusicaFundo {
 private static Clip clip;
    private static FloatControl controleVolume;
    private static int volumeAtual = 70;

    public static void tocarMusica() {
        try {
            if (clip != null && clip.isRunning()) {
                return;
            }

            URL caminho = MusicaFundo.class.getResource("/sounds/musica.wav");

            if (caminho == null) {
                System.out.println("Arquivo de música não encontrado.");
                return;
            }

            AudioInputStream audio = AudioSystem.getAudioInputStream(caminho);
            clip = AudioSystem.getClip();
            clip.open(audio);

            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                controleVolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                setVolume(volumeAtual);
            }

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

        } catch (Exception e) {
            System.out.println("Erro ao tocar música: " + e.getMessage());
        }
    }

    public static void pararMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public static void continuarMusica() {
        if (clip != null && !clip.isRunning()) {
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public static void setVolume(int volume) {
        volumeAtual = volume;

        if (controleVolume == null) {
            return;
        }

        if (volume < 0) {
            volume = 0;
        }

        if (volume > 100) {
            volume = 100;
        }

        float min = controleVolume.getMinimum();
        float max = controleVolume.getMaximum();

        float valor;

        if (volume == 0) {
            valor = min;
        } else {
            valor = min + (max - min) * volume / 100f;
        }

        controleVolume.setValue(valor);
    }

    public static int getVolumeAtual() {
        return volumeAtual;
    }
}
