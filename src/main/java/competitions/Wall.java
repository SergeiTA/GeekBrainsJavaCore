package competitions;

import competitors.Cat;
import competitors.Human;
import competitors.Robot;

public class Wall extends Competition{

    public Wall(String competitionName, int competitionDifficult) {
        super(competitionName, competitionDifficult);
    }


    @Override
    public void competitionResult(String name, int sportsmanSkillRange, Object sportsman) {
        super.competitionResult(name, sportsmanSkillRange, sportsman);

        if (super.getCompetitionDifficult() <= sportsmanSkillRange) {
            System.out.println("ПОЗДРАВЛЯЕМ " + name + " перепрыгнул стену высотой в "
                    + super.getCompetitionDifficult() + " м в соревнованиях со стеной " + super.getCompetitionName());
        } else {
            System.out.println(name + " не смог перепрыгнуть эту стену в соревнованиях со стеной "
                    + super.getCompetitionName());
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
