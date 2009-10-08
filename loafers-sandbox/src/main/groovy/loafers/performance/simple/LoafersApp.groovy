package loafers.performance.simple;

import loafers.Loafers


before = System.currentTimeMillis()

Loafers.app("Loafers", width:300, height:300) {
    button "button", {
       println "You pushed me"
    }
}

after = System.currentTimeMillis()

System.out.println(LoafersApp.class.getName()+" took "+(after-before)+"ms");

System.exit(0)