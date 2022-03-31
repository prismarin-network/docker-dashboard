import {IoLogoDocker} from "react-icons/io5"
import {FiMenu, FiUser} from "react-icons/fi"

declare interface HeaderProps {
    toggleSidebar: () => void;
}

const Header = ({ toggleSidebar }: HeaderProps) => {
    return (
        <div className="flex justify-between fixed top-0 left-0 z-30 bg-blue-400 w-full py-3 px-5">
            <div className="text-white">
                <FiMenu className="lg:hidden" onClick={toggleSidebar} size="2rem" />
            </div>
            <a
                href="https://github.com/prismarin-network/docker-dashboard"
                target="_blank"
                className="flex items-center text-white hover:text-gray-100">
                <IoLogoDocker size="2rem"/>
                <span className="hidden lg:block font-outfit text-xl ml-2">
                    Docker Dashboard
                </span>
            </a>
            <div className="text-white">
                <FiUser className="lg:hidden" size="2rem" />
            </div>
        </div>
    )
}

export default Header
