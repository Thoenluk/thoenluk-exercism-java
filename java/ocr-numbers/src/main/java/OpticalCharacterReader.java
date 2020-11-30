class OpticalCharacterReader {
    private static final OCRNode root;
    
    static {
        root = new OCRNode(OCRSpace.LEFT, -1);
        
        root.setOnNode(new OCRNode(OCRSpace.BOTLEFT, -1));
            root.getOnNode().setOnNode(new OCRNode(OCRSpace.RIGHT, -1));
                root.getOnNode().getOnNode().setOnNode(new OCRNode(OCRSpace.MID, -1));
                    root.getOnNode().getOnNode().getOnNode().setOnNode(new OCRNode(OCRSpace.NONE, 8));
                    root.getOnNode().getOnNode().getOnNode().setOffNode(new OCRNode(OCRSpace.NONE, 0));
                root.getOnNode().getOnNode().setOffNode(new OCRNode(OCRSpace.NONE, 6));
            root.getOnNode().setOffNode(new OCRNode(OCRSpace.RIGHT, -1));
                root.getOnNode().getOffNode().setOnNode(new OCRNode(OCRSpace.TOP, -1));
                    root.getOnNode().getOffNode().getOnNode().setOnNode(new OCRNode(OCRSpace.NONE, 9));
                    root.getOnNode().getOffNode().getOnNode().setOffNode(new OCRNode(OCRSpace.NONE, 4));
                root.getOnNode().getOffNode().setOnNode(new OCRNode(OCRSpace.NONE, 5));
        root.setOffNode(new OCRNode(OCRSpace.MID, -1));
            root.getOffNode().setOnNode(new OCRNode(OCRSpace.BOTLEFT, -1));
                root.getOffNode().getOnNode().setOnNode(new OCRNode(OCRSpace.NONE, 2));
                root.getOffNode().getOnNode().setOffNode(new OCRNode(OCRSpace.NONE, 3));
            root.getOffNode().setOffNode(new OCRNode(OCRSpace.TOP, -1));
                root.getOffNode().getOffNode().setOnNode(new OCRNode(OCRSpace.NONE, 7));
                root.getOffNode().getOffNode().setOffNode(new OCRNode(OCRSpace.NONE, 1));
    }
}

class OCRNode {
    private OCRNode onNode;
    private OCRNode offNode;
    private final OCRSpace checkedSpace;
    private final int value;
    
    public OCRNode(OCRSpace checkedSpace, int value) {
        this.checkedSpace = checkedSpace;
        this.value = value;
    }
    
    public OCRNode getOnNode() {
        return onNode;
    }
    
    public void setOnNode(OCRNode node) {
        this.onNode = node;
    }
    
    public OCRNode getOffNode() {
        return offNode;
    }
    
    public void setOffNode(OCRNode node) {
        this.offNode = node;
    }
    
    public OCRNode getNextNode(char[] digit) {
        return isSpaceOn(digit[checkedSpace.index]) ? onNode : offNode;
    }
    
    public boolean isLeafNode() {
        return checkedSpace != OCRSpace.NONE;
    }
    
    private boolean isSpaceOn(char space) {
        return space != ' ';
    }
}

enum OCRSpace {
    NONE(-1),
    TOP(1),
    LEFT(3),
    MID(4),
    RIGHT(5),
    BOTLEFT(6),
    BOTTOM(7),
    BOTRIGHT(8);
    
    public final int index;
    
    private OCRSpace(int index) {
        this.index = index;
    }
}