import { Html, Head, Main, NextScript } from 'next/document'

export default function Document() {
    return (
        <Html>
            <Head>
                <meta name='application-name' content='Docker Dashboard' />
                <meta name='apple-mobile-web-app-capable' content='yes' />
                <meta name='apple-mobile-web-app-status-bar-style' content='default' />
                <meta name='apple-mobile-web-app-title' content='Docker Dashboard' />
                <meta name='description' content='A tool for viewing your docker environment on private servers.' />
                <meta name='format-detection' content='telephone=no' />
                <meta name='mobile-web-app-capable' content='yes' />
                <meta name='msapplication-config' content='/icons/browserconfig.xml' />
                <meta name='msapplication-TileColor' content='#1f1b24' />
                <meta name='msapplication-tap-highlight' content='no' />
                <meta name='theme-color' content='#60a5fa' />

                <link rel='manifest' href='/manifest.json' />
                <link rel='shortcut icon' href='/favicon.ico' />
            </Head>
            <body>
                <Main />
                <NextScript />
            </body>
        </Html>
    )
}
