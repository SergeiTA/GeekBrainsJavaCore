package competitions;

import competitors.Cat;
import competitors.Human;
import competitors.Robot;

public class Competition {

    private String competitionName;
    private  int competitionDifficult;


    public Competition(String competitionName, int competitionDifficult) {
        this.competitionName = competitionName;
        this.competitionDifficult = competitionDifficult;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public int getCompetitionDifficult() {
        return competitionDifficult;
    }

    public void setCompetitionDifficult(int competitionDifficult) {
        this.competitionDifficult = competitionDifficult;
    }


    public void competitionResult(String name, int sportsmanSkillRange, Object sportsman) {
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

        if (competitionDifficult <= sportsmanSkillRange) {
            System.out.println("ПОЗДРАВЛЯЕМ " + name + " пробежал дистанцию в "
                    + competitionDifficult + " м на беговой дорожке " + competitionName);
        } else {
            System.out.println(name + " не смог пробежать эту дистанцию на беговой дорожке " + competitionName);
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
