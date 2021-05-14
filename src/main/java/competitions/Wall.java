package competitions;

import competitors.Cat;
import competitors.Human;
import competitors.Robot;

public class Wall {


    private String wallName;
    private int wallHeight;

    public Wall(String wallName, int wallHeight) {
        this.wallHeight = wallHeight;
        this.wallName = wallName;
    }


    public String getWallName() {
        return wallName;
    }

    public void setWallName(String wallName) {
        this.wallName = wallName;
    }

    public int getWallHeight() {
        return wallHeight;
    }

    public void setWallHeight(int wallHeight) {
        this.wallHeight = wallHeight;
    }


    public void jump(String name, int jumpHeight, Object sportsman) {

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

        if (wallHeight <= jumpHeight) {
            System.out.println("ПОЗДРАВЛЯЕМ " + name + " перепрыгнул стену высотой в "
                    + wallHeight + " м в соревнованиях со стеной " + wallName);
        } else {
            System.out.println(name + " не смог перепрыгнуть эту стену в соревнованиях со стеной " + wallName);
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
