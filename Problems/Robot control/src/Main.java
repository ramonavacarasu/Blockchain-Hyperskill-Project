class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {
        int x = robot.getX();
        int y = robot.getY();

        if (x < toX) {
            setDirectionX(robot, robot.getDirection(), Direction.RIGHT);
            while (x < toX) {
                robot.stepForward();
                x++;
            }
        } else if (toX < x) {
            setDirectionX(robot, robot.getDirection(), Direction.LEFT);
            while (toX < x) {
                robot.stepForward();
                x--;
            }
        }

        if (y < toY) {
            setDirectionY(robot, robot.getDirection(), Direction.UP);
            while (y < toY) {
                robot.stepForward();
                y++;
            }
        } else if (toY < y) {
            setDirectionY(robot, robot.getDirection(), Direction.DOWN);
            while (toY < y) {
                robot.stepForward();
                y--;
            }
        }

    }

    public static void setDirectionX(Robot robot, Direction direction, Direction toRedirect) {
        Direction d = direction;
        while (!d.equals(toRedirect)) {
            robot.turnRight();
            switch (d) {
                case UP:
                    d = Direction.RIGHT;
                    break;
                case DOWN:
                    d = Direction.LEFT;
                    break;
                case RIGHT:
                    d = Direction.DOWN;
                    break;
                case LEFT:
                    d = Direction.UP;
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    public static void setDirectionY(Robot robot, Direction direction, Direction toRedirect) {
        Direction d = direction;
        while (!d.equals(toRedirect)) {
            robot.turnLeft();
            switch (d) {
                case UP:
                    d = Direction.LEFT;
                    break;
                case DOWN:
                    d = Direction.RIGHT;
                    break;
                case RIGHT:
                    d = Direction.UP;
                    break;
                case LEFT:
                    d = Direction.DOWN;
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}