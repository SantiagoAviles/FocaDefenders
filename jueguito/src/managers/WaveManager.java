package managers;

import java.util.ArrayList;
import java.util.Arrays;

import events.Wave;
import scenes.Playing;

public class WaveManager {

	private Playing playing;
	private ArrayList<Wave> waves = new ArrayList<>();
	private int enemySpawnTickLimit = 60 * 1;
	private int enemySpawnTick = enemySpawnTickLimit;
	private int enemyIndex, waveIndex;
	private int waveTickLimit = 60 * 5;
	private int waveTick = 0;
	private boolean waveStartTimer, waveTickTimerOver;

	public WaveManager(Playing playing) {
		this.playing = playing;
		createWaves();
	}

	public void update() {
		if (enemySpawnTick < enemySpawnTickLimit)
			enemySpawnTick++;

		if (waveStartTimer) {
			waveTick++;
			if (waveTick >= waveTickLimit) {
				waveTickTimerOver = true;
			}
		}

	}

	public void increaseWaveIndex() {
		waveIndex++;
		waveTick = 0;
		waveTickTimerOver = false;
		waveStartTimer = false;
	}

	public boolean isWaveTimerOver() {

		return waveTickTimerOver;
	}

	public void startWaveTimer() {
		waveStartTimer = true;
	}

	public int getNextEnemy() {
		enemySpawnTick = 0;
		return waves.get(waveIndex).getEnemyList().get(enemyIndex++);
	}

	private void createWaves() {
		waves.add(new Wave(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0))));                         // 1
		waves.add(new Wave(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0))));                   // 2
		waves.add(new Wave(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 1))));                      // 3
		waves.add(new Wave(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1, 1, 1, 1))));                // 4
		waves.add(new Wave(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2, 2, 2))));                   // 5
		waves.add(new Wave(new ArrayList<>(Arrays.asList(1, 2, 2, 2, 2, 2, 2, 2))));                // 6
		waves.add(new Wave(new ArrayList<>(Arrays.asList(2, 2, 2, 3, 3, 3))));                      // 7
		waves.add(new Wave(new ArrayList<>(Arrays.asList(2, 2, 2, 3, 3, 3, 3, 3))));                // 8
		waves.add(new Wave(new ArrayList<>(Arrays.asList(3, 3, 3, 3, 4, 4))));                      // 9
		waves.add(new Wave(new ArrayList<>(Arrays.asList(3, 3, 4, 4, 4, 4, 4, 1, 1))));             // 10

		waves.add(new Wave(new ArrayList<>(Arrays.asList(4, 4, 4, 4, 4, 5, 5))));                   // 11
		waves.add(new Wave(new ArrayList<>(Arrays.asList(4, 5, 5, 5, 5, 2, 2, 2))));                // 12
		waves.add(new Wave(new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5, 3, 3))));                   // 13
		waves.add(new Wave(new ArrayList<>(Arrays.asList(3, 4, 5, 5, 6))));                         // 14
		waves.add(new Wave(new ArrayList<>(Arrays.asList(5, 5, 5, 6, 6, 6))) );                     // 15
		waves.add(new Wave(new ArrayList<>(Arrays.asList(6, 6, 6, 6, 6))) );                        // 16
		waves.add(new Wave(new ArrayList<>(Arrays.asList(6, 6, 6, 6, 6, 4, 4))) );                  // 17
		waves.add(new Wave(new ArrayList<>(Arrays.asList(6, 6, 7, 7, 7))) );                        // 18
		waves.add(new Wave(new ArrayList<>(Arrays.asList(7, 7, 7, 7, 7))) );                        // 19
		waves.add(new Wave(new ArrayList<>(Arrays.asList(7, 7, 7, 6, 6, 6))) );                     // 20

		waves.add(new Wave(new ArrayList<>(Arrays.asList(7, 8))) );                                 // 21
		waves.add(new Wave(new ArrayList<>(Arrays.asList(7, 7, 8, 8))) );                           // 22
		waves.add(new Wave(new ArrayList<>(Arrays.asList(8, 8, 8, 1, 1))) );                        // 23
		waves.add(new Wave(new ArrayList<>(Arrays.asList(8, 8, 2, 2, 2, 2))) );                     // 24
		waves.add(new Wave(new ArrayList<>(Arrays.asList(8, 8, 8, 6, 6))) );                        // 25
		waves.add(new Wave(new ArrayList<>(Arrays.asList(6, 6, 6, 8, 8, 9))) );                     // 26
		waves.add(new Wave(new ArrayList<>(Arrays.asList(9))) );                                    // 27 - jefe
		waves.add(new Wave(new ArrayList<>(Arrays.asList(7, 7, 9))) );                              // 28
		waves.add(new Wave(new ArrayList<>(Arrays.asList(8, 8, 9, 9))) );                           // 29
		waves.add(new Wave(new ArrayList<>(Arrays.asList(6, 6, 8, 8, 9))) );                        // 30

		waves.add(new Wave(new ArrayList<>(Arrays.asList(0, 0, 1, 2, 3, 4, 5, 6))) );               // 31 - todo el zoo
		waves.add(new Wave(new ArrayList<>(Arrays.asList(5, 5, 5, 5, 6, 6, 7))) );                  // 32
		waves.add(new Wave(new ArrayList<>(Arrays.asList(7, 7, 7, 9))) );                           // 33
		waves.add(new Wave(new ArrayList<>(Arrays.asList(8, 8, 8, 8, 8))) );                        // 34
		waves.add(new Wave(new ArrayList<>(Arrays.asList(6, 7, 8, 9))) );                           // 35
		waves.add(new Wave(new ArrayList<>(Arrays.asList(6, 6, 9, 9))) );                           // 36
		waves.add(new Wave(new ArrayList<>(Arrays.asList(7, 7, 9, 9))) );                           // 37
		waves.add(new Wave(new ArrayList<>(Arrays.asList(6, 7, 8, 9, 9, 9))) );                     // 38
		waves.add(new Wave(new ArrayList<>(Arrays.asList(9, 9, 9, 9))) );                           // 39
		waves.add(new Wave(new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9, 9))) );                     // 40

		waves.add(new Wave(new ArrayList<>(Arrays.asList(1, 1, 1, 6, 6, 9, 9))) );                  // 41
		waves.add(new Wave(new ArrayList<>(Arrays.asList(7, 7, 8, 8, 9, 9, 9))) );                  // 42
		waves.add(new Wave(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9))) );                     // 43
		waves.add(new Wave(new ArrayList<>(Arrays.asList(2, 2, 2, 5, 6, 9))) );                     // 44
		waves.add(new Wave(new ArrayList<>(Arrays.asList(5, 5, 5, 6, 6, 9, 9, 9))) );               // 45
		waves.add(new Wave(new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9))) );                        // 46
		waves.add(new Wave(new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9, 9, 9))) );                  // 47
		waves.add(new Wave(new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9, 9, 9, 9))) );               // 48
		waves.add(new Wave(new ArrayList<>(Arrays.asList(6, 7, 8, 9, 9, 9, 9))) );                  // 49
		waves.add(new Wave(new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9, 9, 9, 9, 9, 9))) );         // 50 - final boss spam

	}

	public ArrayList<Wave> getWaves() {
		return waves;
	}

	public boolean isTimeForNewEnemy() {
		return enemySpawnTick >= enemySpawnTickLimit;
	}

	public boolean isThereMoreEnemiesInWave() {
		return enemyIndex < waves.get(waveIndex).getEnemyList().size();
	}

	public boolean isThereMoreWaves() {
		return waveIndex + 1 < waves.size();
	}

	public void resetEnemyIndex() {
		enemyIndex = 0;
	}

	public int getWaveIndex() {
		return waveIndex;
	}

	public float getTimeLeft() {
		float ticksLeft = waveTickLimit - waveTick;
		return ticksLeft / 60.0f;
	}

	public boolean isWaveTimerStarted() {
		return waveStartTimer;
	}

	public void reset() {
		waves.clear();
		createWaves();
		enemyIndex = 0;
		waveIndex = 0;
		waveStartTimer = false;
		waveTickTimerOver = false;
		waveTick = 0;
		enemySpawnTick = enemySpawnTickLimit;
	}

}
