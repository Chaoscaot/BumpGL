package de.chaoscaot.bumpgl.modmenu;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@me.shedaniel.autoconfig.annotation.Config(name = "bumpgl")
public class Config implements ConfigData {

    @ConfigEntry.Gui.RequiresRestart
    public GLVersion openGlVersion = GLVersion.OPENGL_3_2;

    public enum GLVersion {
        OPENGL_2_0(2, 0),
        OPENGL_2_1(2, 1),
        OPENGL_3_0(3, 0),
        OPENGL_3_1(3, 1),
        OPENGL_3_2(3, 2),
        OPENGL_3_3(3, 3),
        OPENGL_4_0(4, 0),
        OPENGL_4_1(4, 1),
        OPENGL_4_2(4, 2),
        OPENGL_4_3(4, 3),
        OPENGL_4_4(4, 4),
        OPENGL_4_5(4, 5),
        OPENGL_4_6(4, 6);

        public final int major;
        public final int minor;

        GLVersion(int major, int minor) {
            this.major = major;
            this.minor = minor;
        }
    }
}
