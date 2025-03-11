package pages.RMDL.placement;

public enum LinksPlacement {
    LINK_PLACEMENT_MAIN("https://dev.fgislk.at-consulting.ru/rmdl/#/workplace/documents");

    private final String url;

    LinksPlacement(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
