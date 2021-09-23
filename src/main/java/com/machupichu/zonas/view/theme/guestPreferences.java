package com.machupichu.zonas.view.theme;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Scope("session")
public class guestPreferences implements Serializable {

    private String menuMode = "layout-static";

    private String layout = "yana";

    private String theme = "cyan";

    private boolean whiteLogo = true;

    private boolean groupedMenu = false;

    private List<LayoutThemeDark> layoutThemesDark = new ArrayList<LayoutThemeDark>();

    private List<LayoutThemeLight> layoutThemesLight = new ArrayList<LayoutThemeLight>();

    private List<ComponentTheme> componentThemes = new ArrayList<ComponentTheme>();

    @PostConstruct
    public void init() {
        layoutThemesDark.add(new LayoutThemeDark("Dark", "dark", "dark.png", "indigo", true));
        layoutThemesDark.add(new LayoutThemeDark("Island", "island", "island.png", "yellow", true));
        layoutThemesDark.add(new LayoutThemeDark("Ural", "ural", "ural.png", "bluegrey", true));
        layoutThemesDark.add(new LayoutThemeDark("Moss", "moss", "moss.png", "cyan", true));
        layoutThemesDark.add(new LayoutThemeDark("Altai", "altai", "altai.png", "purple", true));
        layoutThemesDark.add(new LayoutThemeDark("Arctic", "arctic", "arctic.png", "blue", true));
        layoutThemesDark.add(new LayoutThemeDark("Baikal", "baikal", "baikal.png", "green", true));
        layoutThemesDark.add(new LayoutThemeDark("Lena", "lena", "lena.png", "purple", true));
        layoutThemesDark.add(new LayoutThemeDark("Yana", "yana", "yana.png", "cyan", true));
        layoutThemesDark.add(new LayoutThemeDark("Tiger", "tiger", "tiger.png", "red", true));
        layoutThemesDark.add(new LayoutThemeDark("Chita", "chita", "chita.png", "purple", true));
        layoutThemesDark.add(new LayoutThemeDark("Kolyma", "kolyma", "kolyma.png", "deeppurple", true));
        layoutThemesDark.add(new LayoutThemeDark("Caspian", "caspian", "caspian.png", "bluegrey", true));
        layoutThemesDark.add(new LayoutThemeDark("Tomsk", "tomsk", "tomsk.png", "red", true));
        layoutThemesDark.add(new LayoutThemeDark("Barnaul", "barnaul", "barnaul.png", "indigo", true));
        layoutThemesDark.add(new LayoutThemeDark("Magadan", "magadan", "magadan.png", "brown", true));
        layoutThemesDark.add(new LayoutThemeDark("Omsk", "omsk", "omsk.png", "purple", true));
        layoutThemesDark.add(new LayoutThemeDark("Kyzyl", "kyzyl", "kyzyl.png", "purple", true));

        layoutThemesLight.add(new LayoutThemeLight("Light", "light", "light.png", "turquoise", false));
        layoutThemesLight.add(new LayoutThemeLight("Mansi", "mansi", "mansi.png", "red", false));
        layoutThemesLight.add(new LayoutThemeLight("Volga", "volga", "volga.png", "bluegrey", false));
        layoutThemesLight.add(new LayoutThemeLight("Sakha", "sakha", "sakha.png", "cyan", true));
        layoutThemesLight.add(new LayoutThemeLight("Anadyr", "anadyr", "anadyr.png", "turquoise", false));
        layoutThemesLight.add(new LayoutThemeLight("Kurgan", "kurgan", "kurgan.png", "amber", false));
        layoutThemesLight.add(new LayoutThemeLight("Tuva", "tuva", "tuva.png", "pink", false));
        layoutThemesLight.add(new LayoutThemeLight("Yakut", "yakut", "yakut.png", "green", false));
        layoutThemesLight.add(new LayoutThemeLight("North", "north", "north.png", "bluegrey", false));
        layoutThemesLight.add(new LayoutThemeLight("Uvs", "uvs", "uvs.png", "purple", true));
        layoutThemesLight.add(new LayoutThemeLight("Yenise", "yenise", "yenise.png", "indigo", true));

        componentThemes.add(new ComponentTheme("Turquoise", "turquoise", "turquoise.png"));
        componentThemes.add(new ComponentTheme("Amber", "amber", "amber.png"));
        componentThemes.add(new ComponentTheme("Red", "red", "red.png"));
        componentThemes.add(new ComponentTheme("Pink", "pink", "pink.png"));
        componentThemes.add(new ComponentTheme("Yellow", "yellow", "yellow.png"));
        componentThemes.add(new ComponentTheme("Brown", "brown", "brown.png"));
        componentThemes.add(new ComponentTheme("Teal", "teal", "teal.png"));
        componentThemes.add(new ComponentTheme("Deep Purple", "deeppurple", "deeppurple.png"));
        componentThemes.add(new ComponentTheme("Blue", "blue", "blue.png"));
        componentThemes.add(new ComponentTheme("Indigo", "indigo", "indigo.png"));
        componentThemes.add(new ComponentTheme("Lime", "lime", "lime.png"));
        componentThemes.add(new ComponentTheme("Green", "green", "green.png"));
        componentThemes.add(new ComponentTheme("Purple", "purple", "purple.png"));
        componentThemes.add(new ComponentTheme("Blue Grey", "bluegrey", "bluegrey.png"));
        componentThemes.add(new ComponentTheme("Cyan", "cyan", "cyan.png"));
    }

    public String getLayout() {
        return layout;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setLayout(String layout, String theme, boolean logo) {
        this.layout = layout;
        this.theme = theme;
        this.whiteLogo = logo;
    }

    public boolean isWhiteLogo() {
        return this.whiteLogo;
    }

    public String getMenuMode() {
        return this.menuMode;
    }

    public void setMenuMode(String menuMode) {
        this.menuMode = menuMode;

        if (this.menuMode.equals("layout-megamenu")) {
            this.groupedMenu = true;
        }
    }

    public boolean isGroupedMenu() {
        return this.groupedMenu;
    }

    public void setGroupedMenu(boolean value) {
        this.groupedMenu = value;
    }

    public List<LayoutThemeDark> getLayoutThemesDark() {
        return layoutThemesDark;
    }

    public List<LayoutThemeLight> getLayoutThemesLight() {
        return layoutThemesLight;
    }

    public List<ComponentTheme> getComponentThemes() {
        return componentThemes;
    }

    public class LayoutThemeDark {
        String name;
        String file;
        String image;
        String theme;
        boolean logo;

        public LayoutThemeDark(String name, String file, String image, String theme, boolean logo) {
            this.name = name;
            this.file = file;
            this.image = image;
            this.theme = theme;
            this.logo = logo;
        }

        public String getName() {
            return this.name;
        }

        public String getFile() {
            return this.file;
        }

        public String getImage() {
            return this.image;
        }

        public String getTheme() {
            return this.theme;
        }

        public boolean getLogo() {
            return this.logo;
        }
    }

    public class LayoutThemeLight {
        String name;
        String file;
        String image;
        String theme;
        boolean logo;

        public LayoutThemeLight(String name, String file, String image, String theme, boolean logo) {
            this.name = name;
            this.file = file;
            this.image = image;
            this.theme = theme;
            this.logo = logo;
        }

        public String getName() {
            return this.name;
        }

        public String getFile() {
            return this.file;
        }

        public String getImage() {
            return this.image;
        }

        public String getTheme() {
            return this.theme;
        }

        public boolean getLogo() {
            return this.logo;
        }
    }

    public class ComponentTheme {
        String name;
        String file;
        String image;

        public ComponentTheme(String name, String file, String image) {
            this.name = name;
            this.file = file;
            this.image = image;
        }

        public String getName() {
            return this.name;
        }

        public String getFile() {
            return this.file;
        }

        public String getImage() {
            return this.image;
        }
    }

}
