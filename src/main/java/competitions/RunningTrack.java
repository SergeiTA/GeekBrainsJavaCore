package competitions;

import competitors.Cat;
import competitors.Human;
import competitors.Robot;

public class RunningTrack {

    private String trackName;
    private int raceRange;


    public RunningTrack(String trackName, int raceRange) {
        this.raceRange = raceRange;
        this.trackName = trackName;
    }


    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getRaceRange() {
        return raceRange;
    }

    public void setRaceRange(int raceRange) {
        this.raceRange = raceRange;
    }


    public void run(String name, int runRange, Object sportsman) {
        boolean haveNoLose;

        if (sportsman == null) {
            System.out.println("sportsman is NULL");
            return;
        }

        if (sportsman instanceof Human) {
            haveNoLose = ((Human) sportsman).isHaveNoLose();
        } else if (sportsman instanceof Cat) {
            haveNoLose = ((Cat) sportsman).isHaveNoLose();
        } else {
            haveNoLose = ((Robot) sportsman).isHaveNoLose();
        }

        if (!haveNoLose) {
            System.out.println("!!! После проигрыша " + name + " не может участвовать в соревнованиях");
            return;
        }

        if (raceRange <= runRange) {
            System.out.println("ПОЗДРАВЛЯЕМ " + name + " пробежал дистанцию в "
                    + raceRange + " м на беговой дорожке " + trackName);
        } else {
            System.out.println(name + " не смог пробежать эту дистанцию на беговой дорожке " + trackName);
            if (sportsman instanceof Human) {
                ((Human) sportsman).setHaveNoLose(false);
            } else if (sportsman instanceof Cat) {
                ((Cat) sportsman).setHaveNoLose(false);
            } else {
                ((Robot) sportsman).setHaveNoLose(false);
            }
        }
    }

}
