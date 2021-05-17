package competitions;

import competitors.Cat;
import competitors.Human;
import competitors.Robot;

public class RunningTrack extends Competition{

    public RunningTrack(String competitionName, int competitionDifficult) {
        super(competitionName, competitionDifficult);
    }

    @Override
    public void competitionResult(String name, int sportsmanSkillRange, Object sportsman) {
        super.competitionResult(name, sportsmanSkillRange, sportsman);

        if (super.getCompetitionDifficult() <= sportsmanSkillRange) {
            System.out.println("ПОЗДРАВЛЯЕМ " + name + " пробежал дистанцию в "
                    + super.getCompetitionDifficult() + " м на беговой дорожке " + super.getCompetitionName());
        } else {
            System.out.println(name + " не смог пробежать эту дистанцию на беговой дорожке " + getCompetitionName());
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
