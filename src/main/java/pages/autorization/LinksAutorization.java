package pages.autorization;

public enum LinksAutorization {

    LINK_RMDL_MAIN("https://dev.fgislk.at-consulting.ru/rmdl"),
    LINK_LKL_MAIN("https://pub.dev.fgislk.at-consulting.ru/lkl/#/cabinet");

    private final String url;

    LinksAutorization(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
