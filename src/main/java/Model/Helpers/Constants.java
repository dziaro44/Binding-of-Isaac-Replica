package Model.Helpers;

public class Constants {
    public static final int         KEY_FRAME_DURATION  = 20;
    public static final int         KEY_FRAME_SCALE     = KEY_FRAME_DURATION/10;
    public static final int         MAP_SIZE            = 3;

    public static final int         PLAYER_START_HP             = 100;
    public static final int         PLAYER_START_DMG            = 20;
    public static final double      PLAYER_START_SPEED          = 4*KEY_FRAME_SCALE;
    public static final int         PLAYER_START_ATTACK_DELAY   = 40/KEY_FRAME_SCALE;
    public static final double      PLAYER_START_SHOT_SPEED     = 6*KEY_FRAME_SCALE;
    public static final int         PLAYER_MIN_ATTACK_DELAY     = 10/KEY_FRAME_SCALE;

    public static final int         PLAYER_BIG_HP_BONUS             = 30;
    public static final int         PLAYER_BIG_DMG_BONUS            = 5;
    public static final double      PLAYER_BIG_SPEED_BONUS          = 0.5*KEY_FRAME_SCALE;
    public static final int         PLAYER_BIG_ATTACK_DELAY_BONUS   = 2/KEY_FRAME_SCALE;

    public static final int         PLAYER_SMALL_HP_BONUS           = 10;
    public static final int         PLAYER_SMALL_DMG_BONUS          = 1;

    public static final int         ENEMY_HP             = 50;
    public static final int         ENEMY_DMG            = 5;
    public static final double      ENEMY_SPEED_BOUND    = 2.5*KEY_FRAME_SCALE;
    public static final int         ENEMY_ATTACK_DELAY   = 60/KEY_FRAME_SCALE;
    public static final double      ENEMY_SHOT_SPEED     = 3*KEY_FRAME_SCALE;

    public static final double      ENEMY_RADIUS        = 15;
    public static final double      PLAYER_RADIUS       = 10;
    public static final double      BULLET_RADIUS       = 4;

    public static final double      ROOM_WIDTH          = 1280;
    public static final double      ROOM_HEIGHT         = 720;
}
