package com.company.managers;

import com.company.Bot.BotManager;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameManeger {
    private int first;
    private int second;
    private boolean isAnsver;

    public interface IGameCallbsck {
        void onNewQuestion(int first, int second);

        void onGaneOver();
    }

    private IGameCallbsck callback;
    private Timer timer;

    private GameManeger() {
        timer = new Timer(); // Required private constructor
        isAnsver = true;
    }

    /**
     * Singleton: thread save class defining singleton for {@link BotManager} class
     */
    private static class Singleton {
        private static GameManeger sInstance = new GameManeger();

        private Singleton() {
            // Required empty constructor to prevent instantiation
        }
    }

    /**
     * Singleton: getting singleton instance of {@link GameManeger} class
     *
     * @return {@link GameManeger} instance
     */

    public static GameManeger getInstance() {
        return GameManeger.Singleton.sInstance;
    }

    public void startGame(IGameCallbsck callback) {
        this.callback = callback;

        newQuestion();
    }

    private void newQuestion() {
        timer.cancel();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!isAnsver) {
                    gameOver();
                    return;
                }

                Random random = new Random();
                first = random.nextInt(9);
                second = random.nextInt(9);
                callback.onNewQuestion(first, second);
                isAnsver = false;
            }
        }, 0, 10000);
    }

    /*/

     */
    private void gameOver() {
        timer.cancel();
        callback.onGaneOver();
    }

    /**
     * @param resul
     */
    public void check(int resul) {
        if (resul == first * second) {
            isAnsver = true;
            timer.cancel();
            newQuestion();
        } else {
            gameOver();
        }
    }

}

