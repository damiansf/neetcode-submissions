class BrowserHistory {

    private static class Page {
        String url;
        Page next;
        Page cur;

        Page(String url) {
            this.url=url;
            this.next=this.cur=null;
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
        current.next = newPage;
        newPage.prev = current;
        current=newPage;
    }
    
    public String back(int steps) {
        while (steps>0 && current.prev != null) {
            current=current.prev;
            steps--;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        while(steps>0 && current.next !=null) {
            current=current.next;
            steps--;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */