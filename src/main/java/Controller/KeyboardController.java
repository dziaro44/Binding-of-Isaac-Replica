package Controller;

import Model.Helpers.Direction;
import Model.Helpers.PlayerAction;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class KeyboardController {
    private boolean keyW, keyA, keyS, keyD;
    private boolean keyUp, keyLeft, keyDown, keyRight;
    private boolean key1, key2, key3, key4;
    private boolean keyK;

    public KeyboardController() {
        keyW = false;
        keyA = false;
        keyS = false;
        keyD = false;

        keyUp = false;
        keyLeft = false;
        keyDown = false;
        keyRight = false;

        key1 = false;
        key2 = false;
        key3 = false;
        key4 = false;

        keyK = false;
    }
    public KeyboardController(KeyboardController copy) {
        this.keyW = copy.keyW;
        this.keyA = copy.keyA;
        this.keyS = copy.keyS;
        this.keyD = copy.keyD;

        this.keyUp      = copy.keyUp;
        this.keyLeft    = copy.keyLeft;
        this.keyDown    = copy.keyDown;
        this.keyRight   = copy.keyRight;

        this.key1       = copy.key1;
        this.key2       = copy.key2;
        this.key3       = copy.key3;
        this.key4       = copy.key4;

        this.keyK       = copy.keyK;
    }

    public boolean isKeyW() { return keyW; }
    public boolean isKeyA() { return keyA; }
    public boolean isKeyS() { return keyS; }
    public boolean isKeyD() { return keyD; }

    public boolean isKeyUp() { return keyUp; }
    public boolean isKeyLeft() { return keyLeft; }
    public boolean isKeyDown() { return keyDown; }
    public boolean isKeyRight() { return keyRight; }

    public boolean isKey1() { return key1; }
    public boolean isKey2() { return key2; }
    public boolean isKey3() { return key3; }
    public boolean isKey4() { return key4; }

    public boolean isKeyK() { return keyK; }

    public void setKeyW(boolean keyW) { this.keyW = keyW; }
    public void setKeyA(boolean keyA) { this.keyA = keyA; }
    public void setKeyS(boolean keyS) { this.keyS = keyS; }
    public void setKeyD(boolean keyD) { this.keyD = keyD; }

    public void setKeyUp(boolean keyUp) { this.keyUp = keyUp; }
    public void setKeyLeft(boolean keyLeft) { this.keyLeft = keyLeft; }
    public void setKeyDown(boolean keyDown) { this.keyDown = keyDown; }
    public void setKeyRight(boolean keyRight) { this.keyRight = keyRight; }

    public void setKey1(boolean key1) {
        if (count1234() == 0) this.key1 = key1;
    }
    public void setKey2(boolean key2) {
        if (count1234() == 0) this.key2 = key2;
    }
    public void setKey3(boolean key3) {
        if (count1234() == 0) this.key3 = key3;
    }
    public void setKey4(boolean key4) {
        if (count1234() == 0) this.key4 = key4;
    }

    public void setKeyK(boolean keyK) { this.keyK = keyK; }

    public int countWSAD() {
        int result = 0;
        if(keyW) result++;
        if(keyA) result++;
        if(keyS) result++;
        if(keyD) result++;
        return result;
    }
    public int countArrows() {
        int result = 0;
        if(keyUp) result++;
        if(keyLeft) result++;
        if(keyDown) result++;
        if(keyRight) result++;
        return result;
    }
    public int count1234() {
        int result = 0;
        if(key1) result++;
        if(key2) result++;
        if(key3) result++;
        if(key4) result++;
        return result;
    }

    public void clear1234() {
        this.key1 = false;
        this.key2 = false;
        this.key3 = false;
        this.key4 = false;
    }

    public void updatePlayerAction(PlayerAction playerAction) {
        KeyboardController actKeyController = new KeyboardController(this);
        if(actKeyController.countWSAD() == 0 || actKeyController.countWSAD() > 2) {
            playerAction.setMoving(false);
        }
        else {
            playerAction.setMoving(true);
            if(actKeyController.countWSAD() == 2) {
                if (actKeyController.isKeyW() && actKeyController.isKeyD())
                    playerAction.setMoveDirection(Direction.RIGHT_DOWN);
                else if (actKeyController.isKeyS() && actKeyController.isKeyD())
                    playerAction.setMoveDirection(Direction.RIGHT_UP);
                else if (actKeyController.isKeyW() && actKeyController.isKeyA())
                    playerAction.setMoveDirection(Direction.LEFT_DOWN);
                else if (actKeyController.isKeyS() && actKeyController.isKeyA())
                    playerAction.setMoveDirection(Direction.LEFT_UP);
                else
                    playerAction.setMoving(false);
            }
            else {
                if (actKeyController.isKeyW())
                    playerAction.setMoveDirection(Direction.DOWN);
                else if (actKeyController.isKeyD())
                    playerAction.setMoveDirection(Direction.RIGHT);
                else if (actKeyController.isKeyS())
                    playerAction.setMoveDirection(Direction.UP);
                else if (actKeyController.isKeyA())
                    playerAction.setMoveDirection(Direction.LEFT);
            }
        }

        if(actKeyController.countArrows() == 0 || actKeyController.countArrows() > 2) {
            playerAction.setShooting(false);
        }
        else {
            playerAction.setShooting(true);
            if(actKeyController.countArrows() == 2) {
                if (actKeyController.isKeyUp() && actKeyController.isKeyRight())
                    playerAction.setShootDirection(Direction.RIGHT_DOWN);
                else if (actKeyController.isKeyDown() && actKeyController.isKeyRight())
                    playerAction.setShootDirection(Direction.RIGHT_UP);
                else if (actKeyController.isKeyUp() && actKeyController.isKeyLeft())
                    playerAction.setShootDirection(Direction.LEFT_DOWN);
                else if (actKeyController.isKeyDown() && actKeyController.isKeyLeft())
                    playerAction.setShootDirection(Direction.LEFT_UP);
                else
                    playerAction.setShooting(false);
            }
            else {
                if (actKeyController.isKeyUp())
                    playerAction.setShootDirection(Direction.DOWN);
                else if (actKeyController.isKeyRight())
                    playerAction.setShootDirection(Direction.RIGHT);
                else if (actKeyController.isKeyDown())
                    playerAction.setShootDirection(Direction.UP);
                else if (actKeyController.isKeyLeft())
                    playerAction.setShootDirection(Direction.LEFT);
            }
        }
        if(actKeyController.isKey1()) {
            playerAction.setUpgradeHealth(true);
        }
        else if(actKeyController.isKey2()) {
            playerAction.setUpgradeDamage(true);
        }
        else if(actKeyController.isKey3()) {
            playerAction.setUpgradeSpeed(true);
        }
        else if(actKeyController.isKey4()) {
            playerAction.setUpgradeAttackDelay(true);
        }
        else {
            playerAction.clearUpgrades();
        }

        if(actKeyController.isKeyK()) {
            playerAction.setCheatKillAll(true);
        }
    }

    public void enableMainKeys(Scene scene) {
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
                setKeyW(true);
            }
            else if (e.getCode() == KeyCode.A) {
                setKeyA(true);
            }
            else if (e.getCode() == KeyCode.S) {
                setKeyS(true);
            }
            else if (e.getCode() == KeyCode.D) {
                setKeyD(true);
            }
            else if (e.getCode() == KeyCode.UP) {
                setKeyUp(true);
            }
            else if (e.getCode() == KeyCode.LEFT) {
                setKeyLeft(true);
            }
            else if (e.getCode() == KeyCode.DOWN) {
                setKeyDown(true);
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                setKeyRight(true);
            }
        });
        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.W) {
                setKeyW(false);
            }
            else if (e.getCode() == KeyCode.A) {
                setKeyA(false);
            }
            else if (e.getCode() == KeyCode.S) {
                setKeyS(false);
            }
            else if (e.getCode() == KeyCode.D) {
                setKeyD(false);
            }
            else if (e.getCode() == KeyCode.UP) {
                setKeyUp(false);
            }
            else if (e.getCode() == KeyCode.LEFT) {
                setKeyLeft(false);
            }
            else if (e.getCode() == KeyCode.DOWN) {
                setKeyDown(false);
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                setKeyRight(false);
            }
        });
    }

    public void enable12Keys(Scene scene) {
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
                setKeyW(true);
            }
            else if (e.getCode() == KeyCode.A) {
                setKeyA(true);
            }
            else if (e.getCode() == KeyCode.S) {
                setKeyS(true);
            }
            else if (e.getCode() == KeyCode.D) {
                setKeyD(true);
            }
            else if (e.getCode() == KeyCode.UP) {
                setKeyUp(true);
            }
            else if (e.getCode() == KeyCode.LEFT) {
                setKeyLeft(true);
            }
            else if (e.getCode() == KeyCode.DOWN) {
                setKeyDown(true);
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                setKeyRight(true);
            }
            else if (e.getCode() == KeyCode.DIGIT1) {
                setKey1(true);
            }
            else if (e.getCode() == KeyCode.DIGIT2) {
                setKey2(true);
            }
        });
    }

    public void enable1234Keys(Scene scene) {
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
                setKeyW(true);
            }
            else if (e.getCode() == KeyCode.A) {
                setKeyA(true);
            }
            else if (e.getCode() == KeyCode.S) {
                setKeyS(true);
            }
            else if (e.getCode() == KeyCode.D) {
                setKeyD(true);
            }
            else if (e.getCode() == KeyCode.UP) {
                setKeyUp(true);
            }
            else if (e.getCode() == KeyCode.LEFT) {
                setKeyLeft(true);
            }
            else if (e.getCode() == KeyCode.DOWN) {
                setKeyDown(true);
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                setKeyRight(true);
            }
            else if (e.getCode() == KeyCode.DIGIT1) {
                setKey1(true);
            }
            else if (e.getCode() == KeyCode.DIGIT2) {
                setKey2(true);
            }
            else if (e.getCode() == KeyCode.DIGIT3) {
                setKey3(true);
            }
            else if (e.getCode() == KeyCode.DIGIT4) {
                setKey4(true);
            }
        });
    }

    public void disableExtraKeys(Scene scene) {
        clear1234();
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
                setKeyW(true);
            }
            else if (e.getCode() == KeyCode.A) {
                setKeyA(true);
            }
            else if (e.getCode() == KeyCode.S) {
                setKeyS(true);
            }
            else if (e.getCode() == KeyCode.D) {
                setKeyD(true);
            }
            else if (e.getCode() == KeyCode.UP) {
                setKeyUp(true);
            }
            else if (e.getCode() == KeyCode.LEFT) {
                setKeyLeft(true);
            }
            else if (e.getCode() == KeyCode.DOWN) {
                setKeyDown(true);
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                setKeyRight(true);
            }
        });
    }

    public void enableMainKeysWithCheats(Scene scene) {
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
                setKeyW(true);
            }
            else if (e.getCode() == KeyCode.A) {
                setKeyA(true);
            }
            else if (e.getCode() == KeyCode.S) {
                setKeyS(true);
            }
            else if (e.getCode() == KeyCode.D) {
                setKeyD(true);
            }
            else if (e.getCode() == KeyCode.UP) {
                setKeyUp(true);
            }
            else if (e.getCode() == KeyCode.LEFT) {
                setKeyLeft(true);
            }
            else if (e.getCode() == KeyCode.DOWN) {
                setKeyDown(true);
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                setKeyRight(true);
            }
            else if (e.getCode() == KeyCode.K) {
                setKeyK(true);
            }
        });
        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.W) {
                setKeyW(false);
            }
            else if (e.getCode() == KeyCode.A) {
                setKeyA(false);
            }
            else if (e.getCode() == KeyCode.S) {
                setKeyS(false);
            }
            else if (e.getCode() == KeyCode.D) {
                setKeyD(false);
            }
            else if (e.getCode() == KeyCode.UP) {
                setKeyUp(false);
            }
            else if (e.getCode() == KeyCode.LEFT) {
                setKeyLeft(false);
            }
            else if (e.getCode() == KeyCode.DOWN) {
                setKeyDown(false);
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                setKeyRight(false);
            }
            else if (e.getCode() == KeyCode.K) {
                setKeyK(false);
            }
        });
    }

    public void disableExtraKeysWithCheats(Scene scene) {
        clear1234();
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
                setKeyW(true);
            }
            else if (e.getCode() == KeyCode.A) {
                setKeyA(true);
            }
            else if (e.getCode() == KeyCode.S) {
                setKeyS(true);
            }
            else if (e.getCode() == KeyCode.D) {
                setKeyD(true);
            }
            else if (e.getCode() == KeyCode.UP) {
                setKeyUp(true);
            }
            else if (e.getCode() == KeyCode.LEFT) {
                setKeyLeft(true);
            }
            else if (e.getCode() == KeyCode.DOWN) {
                setKeyDown(true);
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                setKeyRight(true);
            }
            else if (e.getCode() == KeyCode.K) {
                setKeyK(true);
            }
        });
    }
}
