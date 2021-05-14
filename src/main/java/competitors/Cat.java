package competitors;

import interfaces.SportSkills;

public class Cat implements SportSkills {
    private String name;
    private int jumpHeight;
    private int runRange;
    private boolean haveNoLose;

    public Cat(String name, int jumpHeight, int runRange) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runRange = runRange;
        this.haveNoLose = true;
    }

    public boolean isHaveNoLose() {
        return haveNoLose;
    }

    public void setHaveNoLose(boolean haveNoLose) {
        this.haveNoLose = haveNoLose;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public int getRunRange() {
        return runRange;
    }

    public void setRunRange(int runRange) {
        this.runRange = runRange;
    }


    @Override
    public void run() {
        System.out.println(name + " бежит");
    }

    @Override
    public void jump() {
        System.out.println(name + " прыгает");
    }
}
