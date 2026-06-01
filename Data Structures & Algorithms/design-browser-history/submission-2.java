class BrowserHistory {

    private static class Page {
        String url;
        Page next;
        Page prev;

        Page(String url) {
            this.url=url;
            this.next=this.prev=null;
        }

    }

    Page currPage;

    // homePage
    // homePage -> google
    // homePage -> google -> facebook -> messenger
    // homePage -> google

    public BrowserHistory(String homepage) {
        this.currPage = new Page(homepage);
    }
    
    public void visit(String url) {
        if(url == null) {
            return;
        }
        Page newPage = new Page(url);
        currPage.next = newPage;
        newPage.prev = currPage;
        currPage=newPage;
    }
    
    public String back(int steps) {
        while (steps>0 && currPage.prev != null) {
            currPage=currPage.prev;
            steps--;
        }
        return currPage.url;
    }
    
    public String forward(int steps) {
        while(steps>0 && currPage.next !=null) {
            currPage=currPage.next;
            steps--;
        }
        return currPage.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */