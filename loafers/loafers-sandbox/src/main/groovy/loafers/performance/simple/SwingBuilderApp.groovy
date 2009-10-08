package loafers.performance.simple;

import groovy.swing.SwingBuilder


before = System.currentTimeMillis()

def swing = new SwingBuilder()

def frame = swing.frame(title:'SwingBuilder', size:[300,300]) {
  flowLayout()
  button(text:'Button',
         actionPerformed: { println "You pushed me" })
}
frame.show()


after = System.currentTimeMillis()

System.out.println(SwingBuilderApp.class.getName()+" took "+(after-before)+"ms");

System.exit(0)