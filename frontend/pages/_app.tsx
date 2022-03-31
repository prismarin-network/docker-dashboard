import '../styles/global.css'
import '../plugins/persistent-store.plugin'

import ProgressBar from "@badrap/bar-of-progress";
import Router from "next/router";
import MantineWrapper from "../components/MantineWrapper";

const progress = new ProgressBar({
    size: 2,
    color: "#7c3aed",
    className: "bar-of-progress",
    delay: 100,
});

Router.events.on("routeChangeStart", progress.start);
Router.events.on("routeChangeComplete", progress.finish);
Router.events.on("routeChangeError", progress.finish);

function MyApp({Component, pageProps}) {
    return (
        <MantineWrapper>
            <Component {...pageProps} />
        </MantineWrapper>
    )
}

export default MyApp
