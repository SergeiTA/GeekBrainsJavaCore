package competitionRunner;

import competitions.RunningTrack;
import competitions.Wall;
import competitors.Cat;
import competitors.Human;
import competitors.Robot;

import java.util.Random;

public class Runner {
    //Так как последовательности, количества и прочие условия не заданы, - будем часто использовать рандом
    static Random random = new Random();

    public static void main(String[] args) {

        runCompetitions(generateCompetitors(), generateCompetitions());


    }


    private static int randomIntervalGenerator (int minBorder, int maxBorder) {
        int difference = maxBorder - minBorder;
        return random.nextInt(difference + 1);
    }

    private static String generateHumanName() {
        String[] humanNames = {
                "Селиверстов Вячеслав Натанович",
                "Суханов Влас Витальевич",
                "Кошелев Тихон Федотович",
                "Дмитриев Осип Юрьевич",
                "Макаров Давид Вадимович",
                "Исакова Юлиана Феликсовна",
                "Быкова Неолина Иринеевна",
                "Прохорова Инесса Кирилловна",
                "Устинова Марианна Артёмовна",
                "Соболева Элина Эдуардовна"
        };

        return humanNames[random.nextInt(humanNames.length)];
    }

    private static String generateCatName() {
        String[] humanNames = {
                "Барсик",
                "Рыжик",
                "Гарфилд",
                "Пушок",
                "Снежок",
                "Пират",
                "Котопес",
                "Мурзик",
                "Мистер кэт",
                "Мурчалкин"
        };

        return humanNames[random.nextInt(humanNames.length)];
    }

    private static Object[] generateCompetitors() {
        //Размеры границ для генерации длины массива пока харкодим, т.к. другого условия не было
        Object [] competitors = new Object[randomIntervalGenerator(3, 9) + 3];

        //Генерим участников соревнований
        for (int i = 0; i < competitors.length; i++) {
            int dice = random.nextInt(3);

            //Величины треков и стен, а так же скилов с эим связанных пока харткодим
            switch (dice) {
                case 0 -> competitors[i] = new Human(generateHumanName(), random.nextInt(5) + 1
                        , random.nextInt(100) + 1);
                case 1 -> competitors[i] = new Cat(generateCatName(), random.nextInt(5) + 1
                        , random.nextInt(100) + 1);
                case 2 -> competitors[i] = new Robot(generateCatName() + " VERSION " + i
                        , random.nextInt(5) + 1, random.nextInt(100) + 1);
            }

        }
        return competitors;
    }


    private static Object[] generateCompetitions() {
        //Размеры границ для генерации длины массива пока харкодим, т.к. другого условия не было
        Object [] competitions = new Object[randomIntervalGenerator(2, 4) + 2];

        //Генерим соревнования
        for (int i = 0; i < competitions.length; i++) {
            int dice = random.nextInt(2);

            //Величины треков и стен, а так же скилов с эим связанных пока харткодим
            switch (dice) {
                case 0 -> competitions[i] = new RunningTrack("Track version " + i
                        , random.nextInt(100) + 1);
                case 1 -> competitions[i] = new Wall("Wall version " + i, random.nextInt(5) + 1);
            }

        }
        return competitions;
    }


    private static void runCompetitions(Object[] competitors, Object[] competitions) {
        for (Object competition : competitions) {

            for (Object competitor : competitors) {
                String name;
                int runRange, jumpHeight;


                if (competitor instanceof Human) {
                    name = ((Human) competitor).getName();
                    runRange = ((Human) competitor).getRunRange();
                    jumpHeight = ((Human) competitor).getJumpHeight();

                } else if (competitor instanceof Cat) {
                    name = ((Cat) competitor).getName();
                    runRange = ((Cat) competitor).getRunRange();
                    jumpHeight = ((Cat) competitor).getJumpHeight();
                } else {
                    name = ((Robot) competitor).getName();
                    runRange = ((Robot) competitor).getRunRange();
                    jumpHeight = ((Robot) competitor).getJumpHeight();
                }

                if (competition instanceof RunningTrack) {
                    ((RunningTrack) competition).competitionResult(name, runRange, competitor);
                } else {
                    ((Wall) competition).competitionResult(name, jumpHeight, competitor);
                }
            }

            System.out.println("");
            System.out.println("-------------------");
            System.out.println("");

        }
    }



}
