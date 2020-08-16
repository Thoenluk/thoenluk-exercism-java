class Twofer {
    String twofer(String name) {
        name = null == name ? "you" : name;
        return "One for " + name + ", one for me.";
    }
}
