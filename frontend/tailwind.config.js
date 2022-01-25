module.exports = {
    content: [
        './pages/**/*.{js,ts,jsx,tsx}',
        './components/**/*.{js,ts,jsx,tsx}',
        './layouts/**/*.{js,ts,jsx,tsx}'
    ],
    theme: {
        extend: {
            colors: {
                'bastille': {
                    DEFAULT: '#1F1B24',
                    '50': '#574C66',
                    '100': '#51475E',
                    '200': '#443C50',
                    '300': '#383141',
                    '400': '#2B2633',
                    '500': '#1F1B24',
                    '600': '#18141B',
                    '700': '#100E13',
                    '800': '#08070A',
                    '900': '#010101'
                },
            }
        }
    },
    plugins: [
        require('@tailwindcss/forms'),
        require('@tailwindcss/line-clamp'),
    ],
}
