package loafers.samples.colors

import loafers.Loafers

Loafers.app(width:400, height:300) {
    background height:"50%", gray
    background width:"50%", gradient(tomato(0.7), olive)
    background width:"10%", black(0.5)
    title "testing", stroke:black(0.5)
}